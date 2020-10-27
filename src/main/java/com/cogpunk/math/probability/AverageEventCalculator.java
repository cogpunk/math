package com.cogpunk.math.probability;

import java.util.SortedMap;
import java.util.TreeMap;

import com.cogpunk.math.NumberOperator;

/**
 * Utility class for calculating the average event from a given profile
 */
public class AverageEventCalculator<E extends Comparable<E>,P extends Number & Comparable<P>> {
	
	private NumberOperator<P> probabilityNumberOperator;
	
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
		
		SortedMap<E,P> sortedMap = new TreeMap<E,P>();
		sortedMap.putAll(profile.map());
		
		// 1. Ascertain the total probabilities
		// 2. Iterator through in natural order until first exceeds
		
		P totalProb = calculateTotalProbability(profile);
		
		P middleProb = probabilityNumberOperator.divide(totalProb, probabilityNumberOperator.cast(2));
		
		P countProb = probabilityNumberOperator.cast(0);
		
		E medianEvent = null;
		
		for (E e : sortedMap.keySet()) {
			
			countProb = probabilityNumberOperator.add(countProb, sortedMap.get(e));
			
			if (countProb.compareTo(middleProb) >= 0) {
				medianEvent = e;
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

}
