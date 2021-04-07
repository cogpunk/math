package com.cogpunk.math.probability;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.cogpunk.math.NumberOperator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Utility class for calculating the average event from a given profile
 */
public class AverageEventCalculator<E extends Comparable<E>,P extends Number & Comparable<P>> {
	
	private final NumberOperator<P> probabilityNumberOperator;
	
	/**
	 * @param probabilityNumberOperator Operator suitable manipulating the events
	 */
	public AverageEventCalculator(NumberOperator<P> probabilityNumberOperator) {
		super();
		this.probabilityNumberOperator = probabilityNumberOperator;
	}
	
	/**
	 * @param profile The profile to evaluate
	 * @return The most likely result
	 */
	public E mode(EventProbabilityProfile<E,P> profile) {
		
		// simply iterate through and identify the most common
		
		E event = null;
		P prob = null;
		
		for (E e : profile.map().keySet()) {
			P p = profile.getProbability(e);
			if (prob == null || p.compareTo(prob) > 0) {
				prob = p;
				event = e;
			}
		}
		
		return event;
	}
	
	/**
	 * Utilises the natural ordering to calculate the middle event
	 * 
	 * @param profile The profile to evaluate
	 * @return The 'middle' (median) event
	 */
	public E median(EventProbabilityProfile<E,P> profile) {

		SortedMap<E, P> sortedMap = new TreeMap<E, P>(profile.map());
		
		// 1. Ascertain the total probabilities
		// 2. Iterator through in natural order until first exceeds
		
		P totalProb = calculateTotalProbability(profile);
		
		P middleProb = probabilityNumberOperator.divide(totalProb, probabilityNumberOperator.cast(2));
		
		P countProb = probabilityNumberOperator.cast(0);
		
		E medianEvent = null;
		
		for (Map.Entry<E, P> e : sortedMap.entrySet()) {
			
			countProb = probabilityNumberOperator.add(countProb, e.getValue());
			
			if (countProb.compareTo(middleProb) >= 0) {
				medianEvent = e.getKey();
				break;
			}
			
		}
		
		return medianEvent;
	}
	
	/**
	 * @param profile the profile
	 * @return The sum of all of the probabilities
	 */
	protected P calculateTotalProbability(EventProbabilityProfile<E,P> profile) {
		P totalProb = probabilityNumberOperator.cast(0);
		
		for (E e : profile.map().keySet()) {
			
			totalProb = probabilityNumberOperator.add(totalProb, profile.getProbability(e));
		}
		
		return totalProb;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AverageEventCalculator)) {
			return false;
		}
		AverageEventCalculator<?, ?> castOther = (AverageEventCalculator<?, ?>) other;
		return new EqualsBuilder().append(probabilityNumberOperator, castOther.probabilityNumberOperator).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(probabilityNumberOperator).toHashCode();
	}

	
	
	

}
