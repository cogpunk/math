package com.cogpunk.math.probability;

import java.util.List;

import com.cogpunk.math.NumberOperator;

/**
 * Strategy to the probabilities together
 * 
 * @param <E> The Number specifying the event
 */
public class EventProbabilityProfileAdditionAggregationStrategy<E extends Number> implements EventProbabilityProfileAggregationStrategy<E, E> {

	private NumberOperator<E> numberOperator;
	
	/**
	 * @param numberOperator The operator stable to manipulating the event
	 */
	public EventProbabilityProfileAdditionAggregationStrategy(NumberOperator<E> numberOperator) {
		this.numberOperator = numberOperator;
	}
	
	/**
	 * Adds all the supplied numerical events together
	 */
	@Override
	public E aggregate(List<E> results) {
		
		E total = numberOperator.cast(0);
		
		for (E r : results)  {
			total = numberOperator.add(total, r);
		}
		
		return total;
		
		
	}


}
