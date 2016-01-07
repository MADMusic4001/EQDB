/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Representation of an Everquest item dropped by an NPC when it dies.
 */
@Entity @IdClass(DropId.class)
public class Drop {
	@Id
	private NPC npc;
	@Id
	private Item item;
	private BigDecimal rate;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((npc == null) ? 0 : npc.hashCode());
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
		Drop other = (Drop) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (npc == null) {
			if (other.npc != null)
				return false;
		} else if (!npc.equals(other.npc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("npc", npc)
				.append("item", item)
				.append("rate", rate)
				.toString();
	}

	public NPC getNpc() {
		return npc;
	}
	public void setNpc(NPC npc) {
		this.npc = npc;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
