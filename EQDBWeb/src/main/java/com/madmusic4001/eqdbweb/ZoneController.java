/**
 * 
 */
package com.madmusic4001.eqdbweb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.madmusic4001.eqdb.beans.ZoneServiceBean;
import com.madmusic4001.eqdb.interfaces.ZoneService;
import com.madmusic4001.eqdb.model.Zone;

/**
 *
 */
@Named(value = "zoneCOntroller")
@RequestScoped
@ManagedBean(name="zoneController", eager=true)
public class ZoneController {
	private List<Zone> zones;
	@EJB
	private ZoneService zoneServiceBean = new ZoneServiceBean();

	/**
	 * Creates a default ZoneController instance
	 */
	public ZoneController() {
		super();
	}

	public List<Zone> getAllZones() {
		zones = zoneServiceBean.getAllZones();
		return zones;
	}

	public List<Zone> getZones() {
		return zones;
	}
	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
}
