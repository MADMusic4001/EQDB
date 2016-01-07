/**
 * 
 */
package com.madmusic4001.eqdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Representation of an Everquest non-player character
 */
@Entity
public class NPC {
	@Id @GeneratedValue
	private int id;
	@Size(max=255)
	private String name;
	private short minLevel;
	private short maxLevel;

	/**
	 * Default constructor needed by JPA
	 */
	public NPC() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NPC other = (NPC) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("id", id)
				.append("name", name)
				.append("minLevel", minLevel)
				.append("maxLevel", maxLevel)
				.toString();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(short minLevel) {
		this.minLevel = minLevel;
	}
	public short getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(short maxLevel) {
		this.maxLevel = maxLevel;
	}
}
