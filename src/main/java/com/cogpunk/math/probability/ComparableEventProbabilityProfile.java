package com.cogpunk.math.probability;

public interface ComparableEventProbabilityProfile<E extends Comparable<E>,P extends Number> extends ProbabilityProfile<E, P> {
	
	/**
	 * @return The probability of the event being greater than or equal to the supplied event
	 */
	public P getProbabilityGreaterThanOrEqualTo(E target) ;
	
	/**
	 * 
	 * @return The probability of the event being less than or equal to the supplied event
	 */
	public P getProbabilityLessThanOrEqualTo(E target);
	
	/**
	 * @return The probability of the event being greater than the supplied event
	 */
	public P getProbabilityGreaterThan(E target);
	
	/**
	 * @return The probability of the event being less than the supplied event
	 */
	public P getProbabilityLessThan(E target);

}
