package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class EventProbabilityProfileHighestAggregationStrategyTest {

	

	@Test
	public void testAggregate() {
		
		Integer[] args = new Integer[] {1,4,6,3,5,2};
		
		assertEquals((Integer) 6, new EventProbabilityProfileHighestAggregationStrategy<Integer>().aggregate(Arrays.asList(args)));
		
		assertEquals(null, new EventProbabilityProfileHighestAggregationStrategy<Integer>().aggregate(new ArrayList<Integer>()));
	}

}
