package com.cogpunk.math.probability;

import java.util.Map;

/**
 * Defines the probability of a set of events from occurring.
 * 
 */
public interface ProbabilityProfile<E, P extends Number> {
	
	/**
	 * @param event  The event in question
	 * @return The probability of the supplied event, or null if the probability is not defined
	 */
	public P getProbability(E event) ;
	
	/**
	 * @return A map containing all of the probabilities, keyed by the events 
	 */
	public Map<E, P> map();
	

}
