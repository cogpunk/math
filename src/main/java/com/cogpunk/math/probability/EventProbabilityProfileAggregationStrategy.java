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
	 * @return The output event probability
	 */
	public E aggregate(List<I> results);
	
	public int hashCode();
	
	public boolean equals(Object obj);

}
