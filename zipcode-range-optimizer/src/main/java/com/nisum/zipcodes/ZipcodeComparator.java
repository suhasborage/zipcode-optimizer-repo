package com.nisum.zipcodes;

import java.util.Comparator;

/**
 * 
 * @author borages
 *
 */
class ZipcodeComparator implements Comparator<ZipcodeRangeValue> {
	public int compare(ZipcodeRangeValue range1, ZipcodeRangeValue range2) {
		return range1.getLowerBound() - range2.getLowerBound();
	}
}