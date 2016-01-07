/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.math.BigDecimal;
import java.util.EnumSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Representation of an Everquest item
 */
@Entity
public class Item {
	@Id @GeneratedValue
	private int id;
	@javax.validation.constraints.Size(min=56, max=56)
	private String eqId;
	@NotNull
	private String name;
	@NotNull
	private BigDecimal weight;
	@NotNull
	private Size size;
	@NotNull
	private boolean lore;
	@NotNull
	private boolean noTrade;
	@NotNull
	private boolean quest;
	@NotNull
	private boolean temporary;
	@NotNull
	private boolean crafted;
	@NotNull
	private EnumSet<Race> usableByRaces;
	@NotNull
	private EnumSet<EQClass> usableByClasses;

	/**
	 * Default constructor needed by JPA
	 */
	public Item() {
	}

	/**
	 * Creates a new Item instance with the specified values.
	 * 
	 * @param eqId  the Everquest item id
	 * @param name  the item name
	 * @param weight  the item weight
	 * @param size  the item size
	 * @param lore  true if the item is Lore
	 * @param noTrade  true if the item is No Trade
	 * @param quest  true if the item is used in a quest
	 * @param temporary  true if the item is temporary
	 * @param crafted  true if the item can be created through a crafting skill
	 * @param usableByRaces an EnumSet containing the {@link Race} enums that can use the item
	 * @param usableByClasses an EnumSet containing the {@link Class} enums that can use the item
	 * @return a new Item instance with the specified values.
	 */
	public Item(String eqId, String name, BigDecimal weight, Size size, boolean lore, boolean noTrade, boolean quest,
			boolean temporary, boolean crafted, EnumSet<Race> usableByRaces, EnumSet<EQClass> usableByClasses) {
		this.eqId = eqId;
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.lore = lore;
		this.noTrade = noTrade;
		this.quest = quest;
		this.temporary = temporary;
		this.crafted = crafted;
		this.usableByRaces = usableByRaces;
		this.usableByClasses = usableByClasses;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
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
				.append("weight", weight)
				.append("size", size)
				.append("lore", lore)
				.append("noTrade", noTrade)
				.append("quest", quest)
				.append("temporary", temporary)
				.append("crafted", crafted)
				.append("usableByRaces", usableByRaces)
				.append("usableByClasses", usableByClasses)
				.toString();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEqId() {
		return eqId;
	}
	public void setEqId(String eqId) {
		this.eqId = eqId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public boolean isLore() {
		return lore;
	}
	public void setLore(boolean lore) {
		this.lore = lore;
	}
	public boolean isNoTrade() {
		return noTrade;
	}
	public void setNoTrade(boolean noTrade) {
		this.noTrade = noTrade;
	}
	public boolean isQuest() {
		return quest;
	}
	public void setQuest(boolean quest) {
		this.quest = quest;
	}
	public boolean isTemporary() {
		return temporary;
	}
	public void setTemporary(boolean temporary) {
		this.temporary = temporary;
	}
	public boolean isCrafted() {
		return crafted;
	}
	public void setCrafted(boolean crafted) {
		this.crafted = crafted;
	}
	public EnumSet<Race> getUsableByRaces() {
		return usableByRaces;
	}
	public void setUsableByRaces(EnumSet<Race> usableByRaces) {
		this.usableByRaces = usableByRaces;
	}
	public EnumSet<EQClass> getUsableByClasses() {
		return usableByClasses;
	}
	public void setUsableByClasses(EnumSet<EQClass> usableByClasses) {
		this.usableByClasses = usableByClasses;
	}
}
