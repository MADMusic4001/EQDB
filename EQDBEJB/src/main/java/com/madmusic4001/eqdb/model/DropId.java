/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Primary key for the representation of an Everquest item drop.
 */
public class DropId implements Serializable {
	private static final long serialVersionUID = 5321399540852869004L;
	private int npc;
	private int item;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item;
		result = prime * result + npc;
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
		DropId other = (DropId) obj;
		if (item != other.item)
			return false;
		if (npc != other.npc)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("npc", npc)
				.append("item", item)
				.toString();
	}

	public int getNpc() {
		return npc;
	}
	public void setNpc(int npc) {
		this.npc = npc;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
}
