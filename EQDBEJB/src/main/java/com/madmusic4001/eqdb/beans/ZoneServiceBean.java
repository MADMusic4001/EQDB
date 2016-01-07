/**
 * 
 */
package com.madmusic4001.eqdb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.madmusic4001.eqdb.interfaces.ZoneService;
import com.madmusic4001.eqdb.model.Zone;

/**
 * @author Mark
 *
 */
@Stateless
public class ZoneServiceBean implements ZoneService {
	@PersistenceContext(unitName="EQDBPU")
	EntityManager em;

	@Override
	public Zone createZone(String name) {
		Zone zone = new Zone(name);
		em.merge(zone);
		return zone;
	}

	@Override
	public List<Zone> getAllZones() {
		TypedQuery<Zone> zoneQuery = em.createQuery("select * from Zone z", Zone.class);
		return zoneQuery.getResultList();
	}
}
