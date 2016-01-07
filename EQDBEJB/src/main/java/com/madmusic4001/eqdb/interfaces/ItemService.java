/**
 * 
 */
package com.madmusic4001.eqdb.interfaces;

import java.math.BigDecimal;
import java.util.EnumSet;

import javax.ejb.Local;

import com.madmusic4001.eqdb.model.EQClass;
import com.madmusic4001.eqdb.model.Item;
import com.madmusic4001.eqdb.model.Race;
import com.madmusic4001.eqdb.model.Size;

/**
 * Interface to manipulate Item instances
 */
@Local
public interface ItemService {
	/**
	 * Creates a new Item instance and persists it to the database
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
	 * @return a new Item instance
	 */
	public Item createItem(String eqId, String name, BigDecimal weight, Size size, boolean lore, boolean noTrade,
			boolean quest, boolean temporary, boolean crafted, EnumSet<Race> usableByRaces, EnumSet<EQClass> usableByClasses);
}
