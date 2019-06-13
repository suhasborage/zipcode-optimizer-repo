package com.nisum.zipcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author borages
 *
 */
public class ZipcodeRangeOptimizer {

	private static String EMPTY_STRING = "";
	private static String SPACE = " ";
	private static String RANGE_SPLITTER = ",";
	private static String RANGE_WRAPPER = "\\[|\\]";

	public List<ZipcodeRangeValue> prepareCollection(String arbirtaryInput) {
		List<ZipcodeRangeValue> zipcodeRanges = null;
		if (arbirtaryInput != null && !arbirtaryInput.equals(EMPTY_STRING)) {
			zipcodeRanges = new ArrayList<ZipcodeRangeValue>();
			String[] zipcodeSets = arbirtaryInput.split(SPACE);
			for (int i = 0; i < zipcodeSets.length; i++) {
				String[] range = zipcodeSets[i].replaceAll(RANGE_WRAPPER, EMPTY_STRING).split(RANGE_SPLITTER);
				int lowerBound = Integer.parseInt(range[0]);
				int upperBound = Integer.parseInt(range[1]);
				zipcodeRanges.add(new ZipcodeRangeValue(lowerBound, upperBound));
			}
		}
		return zipcodeRanges;
	}

	public List<ZipcodeRangeValue> optimizeZipcodeRanges(List<ZipcodeRangeValue> zipcodeRangeList) {

		// return same if there is only 0 or 1 range is available.
		if (zipcodeRangeList == null || zipcodeRangeList.size() == 0 || zipcodeRangeList.size() == 1) {
			return zipcodeRangeList;
		}

		// Sort the Zipcode Range List.
		sortZipcodeRangeListByLowerBound(zipcodeRangeList);

		// First Range in the List.
		ZipcodeRangeValue firstRange = zipcodeRangeList.get(0);
		int lowerBound = firstRange.getLowerBound();
		int upperBound = firstRange.getUpperBound();

		// List to store Optimized Zipcode ranges
		List<ZipcodeRangeValue> result = new ArrayList<ZipcodeRangeValue>();

		// Iterate through the array and merge any overlapping intervals.
		for (int i = 1; i < zipcodeRangeList.size(); i++) {
			ZipcodeRangeValue currentRange = zipcodeRangeList.get(i);
			if (currentRange.getLowerBound() <= upperBound) { // verify overlaping ranges for upperBound
				upperBound = Math.max(currentRange.getUpperBound(), upperBound);
			}else if (currentRange.getLowerBound() <= (upperBound + 1)) { // verify continuous ranges for upperBound
				upperBound = Math.max(currentRange.getUpperBound(), upperBound);
			} else {
				result.add(new ZipcodeRangeValue(lowerBound, upperBound));
				lowerBound = currentRange.getLowerBound();
				upperBound = currentRange.getUpperBound();
			}
		}
		result.add(new ZipcodeRangeValue(lowerBound, upperBound));

		// Return merged interval array.
		return result;
	}

	//
	public void sortZipcodeRangeListByLowerBound(List<ZipcodeRangeValue> zipcodeRangeList) {
		Collections.sort(zipcodeRangeList, new ZipcodeComparator());
	}
}
