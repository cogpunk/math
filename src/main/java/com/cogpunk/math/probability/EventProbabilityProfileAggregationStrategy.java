package com.cogpunk.math.probability;

import java.util.List;

/**
 * Strategy for aggregating probability profile, able to convert between two probability types
 *
 * @param <I> The class type identifying the input probability
 * @param <E> The class type identifying the output probability
 */
public interface EventProbabilityProfileAggregationStrategy<I, E> {
	
	/**
	 * @param results the list of 
	 * @return
	 */
	public E aggregate(List<I> results);

}
