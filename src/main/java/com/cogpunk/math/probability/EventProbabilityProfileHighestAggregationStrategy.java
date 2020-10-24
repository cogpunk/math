package com.cogpunk.math.probability;

import java.util.List;

/**
 * Strategy to return the highest of the defined events
 */
public class EventProbabilityProfileHighestAggregationStrategy<E extends Number & Comparable<E>> implements EventProbabilityProfileAggregationStrategy<E, E> {

	/**
	 * @return The highest probability, as defined by it's own compareTo method
	 */
	@Override
	public E aggregate(List<E> events) {
		
		E highest = null;
		
		for (E e : events)  {
			
			if (highest == null) {
				highest = e;
			} else {
				if (highest.compareTo(e) < 0) {
					highest = e;
				}
			}
			
			
		}
		
		return highest;
	}

}
