package com.cogpunk.math.probability;

import java.util.List;

import com.cogpunk.math.NumberOperator;

/**
 * Streatgy for multiplying all of the events together 
 */
public class EventProbabilityProfileMultiplicationAggregationStrategy<E extends Number>
		implements EventProbabilityProfileAggregationStrategy<E, E> {
	
	private NumberOperator<E> numberOperator;
	
	/**
	 * @param numberOperator suitable for manipulating the events
	 */
	public EventProbabilityProfileMultiplicationAggregationStrategy(NumberOperator<E> numberOperator) {
		this.numberOperator = numberOperator;
	}
	
	
	/**
	 * 
	 * 
	 * @param results  The events to be multipled together
	 * @return All of the supplied events multpled together
	 */
	@Override
	public E aggregate(List<E> results) {
		
		E total = null;
		
		for (E r : results)  {
			if (total == null) {
				total = r;
			} else {
				total = numberOperator.multiply(total, r);
			}
		}
		
		if (total == null) {
			total = numberOperator.cast(1);
		}
		
		return total;
		
		
	}

}
