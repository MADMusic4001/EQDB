/**
 * 
 */
package com.madmusic4001.eqdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Representation of where in Everquest an NPC is located.
 */
@Entity @IdClass(NPCLocationId.class)
public class NPCLocation {
	@Id
	private NPC npc;
	@Id
	private Zone zone;

	/**
	 * Default constructor needed by JPA
	 */
	public NPCLocation() {
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		NPCLocation other = (NPCLocation)obj;
		if(npc == null) {
			if(other.npc != null) {
				return false;
			}
		}
		else if(!npc.equals(other.npc)) {
			return false;
		}
		if(zone == null) {
			if(other.npc != null) {
				return false;
			}
		}
		else if(!zone.equals(other.zone)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((npc == null) ? 0 : npc.hashCode());
		result = prime * result
				+ ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("npc", npc)
				.append("zone", zone)
				.toString();
	}

	public NPC getNpc() {
		return npc;
	}
	public void setNpc(NPC npc) {
		this.npc = npc;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
}
