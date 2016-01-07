/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**Enum representing the playable races in EQ
 * 
 */
public enum Race {
	BARBARIAN,
	DARK_ELF,
	DRAKKIN,
	DWARF,
	ERUDITE,
	FROGLOK,
	GNOME,
	HALF_ELF,
	HALFLING,
	HIGH_ELF,
	HUMAN,
	IKSAR,
	OGRE,
	TROLL,
	VAH_SHIR,
	WOOD_ELF;

	public static final EnumSet<Race> ALL_RACES = EnumSet.allOf(Race.class);
	private static final Map<Integer, Race> ordinalMap = new HashMap<>();

	static {
		for(Race val : ALL_RACES) {
			ordinalMap.put(val.ordinal(), val);
		}
	}

	public static EnumSet<Race> decode(int encoded) {
		EnumSet<Race> ret = EnumSet.noneOf(Race.class);
		int ordinal = 0;
		for(int i = 1; i != 0; i <<= 1) {
			if((i & encoded) != 0) {
				ret.add(ordinalMap.get(ordinal));
			}
			++ordinal;
		}
		return ret;
	}
}
