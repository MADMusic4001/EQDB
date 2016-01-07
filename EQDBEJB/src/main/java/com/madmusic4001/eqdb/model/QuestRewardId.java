/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Primary key for the representation of an Everquest quest reward
 */
public class QuestRewardId implements Serializable {
	private static final long serialVersionUID = -6662540495435416014L;
	private int quest;
	private int item;

	/**
	 * Default constructor needed by JPA
	 */
	public QuestRewardId() {
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("quest", quest)
				.append("item", item)
				.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item;
		result = prime * result + quest;
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
		QuestRewardId other = (QuestRewardId) obj;
		if (item != other.item)
			return false;
		if (quest != other.quest)
			return false;
		return true;
	}

	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
}
