package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EventProbabilityProfileLowestAggregationStrategyTest {
	
	@Test
	public void testAggregate() {
		
		Integer[] args = new Integer[] {3,4,6,1,5,2};
		
		assertEquals(1, new EventProbabilityProfileLowestAggregationStrategy<Integer>().aggregate(Arrays.asList(args)));

		assertNull(new EventProbabilityProfileLowestAggregationStrategy<Integer>().aggregate(new ArrayList<Integer>()));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(EventProbabilityProfileLowestAggregationStrategy.class).verify();
		
	}

}
