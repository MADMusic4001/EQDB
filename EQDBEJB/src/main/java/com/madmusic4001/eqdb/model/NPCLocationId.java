/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Primary key for the representation of an Everquest NPC location
 */
public class NPCLocationId implements Serializable{
	private static final long serialVersionUID = 8351414199598439814L;
	private int npc;
	private short zone;

	/**
	 * Default constructor needed by JPA
	 */
	public NPCLocationId() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + npc;
		result = prime * result + zone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NPCLocationId other = (NPCLocationId) obj;
		if (npc != other.npc)
			return false;
		if (zone != other.zone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("npc", npc)
				.append("zone", zone)
				.toString();
	}

	public int getNpc() {
		return npc;
	}
	public void setNpc(int npc) {
		this.npc = npc;
	}
	public short getZone() {
		return zone;
	}
	public void setZone(short zone) {
		this.zone = zone;
	}
}
