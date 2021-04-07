package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.cogpunk.math.IntegerOperator;
import com.cogpunk.math.probability.EventProbabilityProfileAdditionAggregationStrategy;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EventProbabilityProfileAdditionAggregationStrategyTest {

	@Test
	public void testAggregate() {

		Integer[] args = new Integer[] {1,2,3,4,5,6};
		
		assertEquals(21, new EventProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()).aggregate(Arrays.asList(args)));
		
		assertEquals(0, new EventProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()).aggregate(new ArrayList<Integer>()));
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(EventProbabilityProfileAdditionAggregationStrategy.class).verify();
		
	}

}
