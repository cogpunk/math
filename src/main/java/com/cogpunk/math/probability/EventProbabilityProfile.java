package com.cogpunk.math.probability;

import java.util.Map;

/**
 * Defines the probability of a set of events from occurring.
 * 
 */
public interface EventProbabilityProfile<E, P extends Number> {
	
	/**
	 * @param event  The event in question
	 * @return The probability of the supplied event, or null if the probability is not defined
	 */
    P getProbability(E event) ;
	
	/**
	 * @return A map containing all of the probabilities, keyed by the events 
	 */
    Map<E, P> map();
	
	int hashCode();
	
	boolean equals(Object obj);
	

}
