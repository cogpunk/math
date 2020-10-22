package com.cogpunk.math.probability;

import java.util.List;

import com.cogpunk.math.NumberOperator;

/**
 * Strategy to the probabilities together
 * 
 * @param <E> The Number specifying the event
 */
public class ProbabilityProfileAdditionAggregationStrategy<E extends Number> implements ProbabilityProfileAggregationStrategy<E, E> {

	private NumberOperator<E> numberOperator;
	
	/**
	 * @param numberOperatorThe operator stable to manipulating the event
	 */
	public ProbabilityProfileAdditionAggregationStrategy(NumberOperator<E> numberOperator) {
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
