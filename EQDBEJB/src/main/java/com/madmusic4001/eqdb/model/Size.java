/**
 * 
 */
package com.madmusic4001.eqdb.model;

/**
 * @author Mark
 *
 */
public enum Size {
	TINY("TINY"),
	SMALL("SMALL"),
	MEDIUM("MEDIUM"),
	LARGE("LARGE"),
	GIANT("GIANT");
	private String size;

	private Size(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return size;
	}

	public static Size decode(int encoded) {
		if(encoded == 0) {
			return TINY;
		}
		if(encoded == 1) {
			return Size.SMALL;
		}
		if(encoded == 2) {
			return Size.MEDIUM;
		}
		if(encoded == 3) {
			return Size.LARGE;
		}
		return Size.GIANT;
	}
}
