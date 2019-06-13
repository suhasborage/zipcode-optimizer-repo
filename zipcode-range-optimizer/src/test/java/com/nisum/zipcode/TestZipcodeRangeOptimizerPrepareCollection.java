/**
 * 
 */
package com.nisum.zipcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.nisum.zipcodes.ZipcodeRangeOptimizer;
import com.nisum.zipcodes.ZipcodeRangeValue;


/**
 * @author borages
 *
 */

@RunWith(Parameterized.class)
public class TestZipcodeRangeOptimizerPrepareCollection {
	private String expected;
    private String input;
    

	public TestZipcodeRangeOptimizerPrepareCollection(String expected, String input) {
		this.expected = expected;
		this.input = input;
	}

	@Parameters
	public static Collection prepareTestData() {
		/* Data format : e.g. {expected: null, input: ""} */
		return Arrays.asList(new String[][]{
											{null, ""},  /* e.g. {expected: null, input: ""} */
											{"[[94133,94133]]", "[94133,94133]"}, /* e.g. {expected: "[[94133,94133]]", input: "[94133,94133]"} */
											{"[[94133,94133], [94200,94299], [94226,94399]]", "[94133,94133] [94200,94299] [94226,94399]"} , /* e.g. {expected: "[[94133,94133], [94200,94399]]", input: "[94133,94133] [94200,94299] [94226,94399]"} */
											{"[[10001,20001], [20002,30001]]", "[10001,20001] [20002,30001]"} /* e.g. {expected: "[[10001,30001]]", input: "[10001,20001] [20002,30001]"} */
										});
	}
	
	@Test
	public void testPrepareCollection() {
		ZipcodeRangeOptimizer zipcodeRangeOptimizer = new ZipcodeRangeOptimizer();
		List<ZipcodeRangeValue> zipcodeRangeValues = zipcodeRangeOptimizer.prepareCollection(input);
		assertEquals(expected, zipcodeRangeValues == null? zipcodeRangeValues: zipcodeRangeValues.toString());
	}
	
}
