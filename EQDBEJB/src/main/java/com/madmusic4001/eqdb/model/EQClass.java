/**
 * 
 */
package com.madmusic4001.eqdb.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing the playable classes in EQ
 */
public enum EQClass {
	BARD,
	BEASTLORD,
	BERSERKER,
	CLERIC,
	DRUID,
	ENCHANTER,
	MAGICIAN,
	MONK,
	NECROMANCER,
	PALADIN,
	RANGER,
	ROGUE,
	SHADOWKNIGHT,
	SHAMAN,
	WIZARD;

	public static final EnumSet<EQClass> ALL_CLASSES = EnumSet.allOf(EQClass.class);
	private static final Map<Integer, EQClass> ordinalMap = new HashMap<>();

	static {
		for(EQClass val : ALL_CLASSES) {
			ordinalMap.put(val.ordinal(), val);
		}
	}

	public static EnumSet<EQClass> decode(int encoded) {
		EnumSet<EQClass> ret = EnumSet.noneOf(EQClass.class);
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
