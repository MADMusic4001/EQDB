/**
 * 
 */
package com.madmusic4001.eqdbweb;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.EnumSet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.madmusic4001.eqdb.beans.ItemServiceBean;
import com.madmusic4001.eqdb.interfaces.ItemService;
import com.madmusic4001.eqdb.model.EQClass;
import com.madmusic4001.eqdb.model.Race;
import com.madmusic4001.eqdb.model.Size;

/**
 * @author Mark
 *
 */
@Named(value = "massItemController")
@RequestScoped
@ManagedBean(name="massItemController", eager=true)
public class MassItemController {
	@EJB
	private ItemService itemServiceBean = new ItemServiceBean();
	private String pathName;

	/**
	 * Creates a default ZoneController instance
	 */
	public MassItemController() {
		super();
	}

	public void loadItemsFromFile() {
		try {
			Reader in = new FileReader(pathName);
			Iterable<CSVRecord> records = CSVFormat.newFormat('|').withHeader().parse(in);
			for(CSVRecord record : records) {
				Integer races = Integer.getInteger(record.get("races"));
				EnumSet<Race> racesSet = Race.decode(races);

				Integer classes = Integer.getInteger(record.get("classes"));
				EnumSet<EQClass> classesSet = EQClass.decode(classes);

				itemServiceBean.createItem(
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
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
}
