/**
 * 
 */
package com.madmusic4001.eqdb.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.madmusic4001.eqdb.model.Zone;

/**
 * @author Mark
 *
 */
@Local
public interface ZoneService {
	/**
	 * Creates a new Zone instance.
	 * 
	 * @param name  the name of the new zone
	 * @return a new Zone instance.
	 */
	public Zone createZone(String name);

	/**
	 * Gets all the Zone instances from the database
	 * 
	 * @return a List instance containing a Zone instance for each record in the zone table.
	 */
	public List<Zone> getAllZones();
}
