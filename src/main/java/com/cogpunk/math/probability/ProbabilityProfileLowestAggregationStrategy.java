package com.cogpunk.math.probability;

import java.util.List;

/**
 * Strategy to return the lowest of the defined events, as defined by the event' compareTo method
 */
public class ProbabilityProfileLowestAggregationStrategy<E extends Number & Comparable<E>> implements ProbabilityProfileAggregationStrategy<E, E> {

	/**
	 * @return The lowest event in the supplied list
	 */
	@Override
	public E aggregate(List<E> events) {
		
		E highest = null;
		
		for (E e : events)  {
			
			if (highest == null) {
				highest = e;
			} else {
				if (highest.compareTo(e) > 0) {
					highest = e;
				}
			}
			
			
		}
		
		return highest;
	}
	
}
