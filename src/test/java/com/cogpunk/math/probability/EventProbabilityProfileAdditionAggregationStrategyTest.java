package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.cogpunk.math.IntegerOperator;
import com.cogpunk.math.probability.EventProbabilityProfileAdditionAggregationStrategy;

public class EventProbabilityProfileAdditionAggregationStrategyTest {

	@Test
	public void testAggregate() {

		Integer[] args = new Integer[] {1,2,3,4,5,6};
		
		assertEquals((Integer) 21, new EventProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()).aggregate(Arrays.asList(args)));
		
		assertEquals((Integer) 0, new EventProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()).aggregate(new ArrayList<Integer>()));
		
	}

}
