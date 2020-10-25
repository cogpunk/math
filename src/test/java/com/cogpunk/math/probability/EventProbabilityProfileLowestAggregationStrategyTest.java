package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class EventProbabilityProfileLowestAggregationStrategyTest {
	
	@Test
	public void testAggregate() {
		
		Integer[] args = new Integer[] {3,4,6,1,5,2};
		
		assertEquals((Integer) 1, new EventProbabilityProfileLowestAggregationStrategy<Integer>().aggregate(Arrays.asList(args)));
		
		assertEquals(null, new EventProbabilityProfileLowestAggregationStrategy<Integer>().aggregate(new ArrayList<Integer>()));
	}

}