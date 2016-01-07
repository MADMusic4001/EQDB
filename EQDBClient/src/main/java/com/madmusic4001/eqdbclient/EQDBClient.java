/**
 * 
 */
package com.madmusic4001.eqdbclient;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.EnumSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.madmusic4001.eqdb.model.EQClass;
import com.madmusic4001.eqdb.model.Item;
import com.madmusic4001.eqdb.model.Race;
import com.madmusic4001.eqdb.model.Size;
import com.madmusic4001.eqdb.model.Zone;

/**
 *
 */
public class EQDBClient {
	EntityManagerFactory emf;
	EntityManager em;

	/**
	 * 
	 */
	public EQDBClient() {
		emf = Persistence.createEntityManagerFactory("EQDBPU");
		em = emf.createEntityManager();
	}

	public Zone getZone(String zoneName) {
		em.getTransaction().begin();
		Query q = em.createQuery("select * from Zone z where z.name = :name");
		q.setParameter("name", zoneName);
		Zone zone = (Zone)q.getSingleResult();
		em.getTransaction().commit();

		return zone;
	}

	private void loadData() {
		try {
			Reader in = new FileReader("items.txt");
			Iterable<CSVRecord> records = CSVFormat.newFormat('|').withHeader().parse(in);
			for(CSVRecord record : records) {
				Integer races = Integer.getInteger(record.get("races"));
				EnumSet<Race> racesSet = Race.decode(races);

				Integer classes = Integer.getInteger(record.get("classes"));
				EnumSet<EQClass> classesSet = EQClass.decode(classes);

				Item item = new Item(
				record.get("id"),
				record.get("name"),
				new BigDecimal(record.get("weight")),
				Size.decode(Integer.getInteger(record.get("size"))),
				"-1".equals(record.get("loregroup")),
				"0".equals(record.get("nodrop")),
				false,
				"0".equals(record.get("norent")),
				false,
				racesSet,
				classesSet
				);
				em.merge(item);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EQDBClient client = new EQDBClient();
		client.loadData();
	}
}
