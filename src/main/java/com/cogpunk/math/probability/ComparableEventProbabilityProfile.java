package com.cogpunk.math.probability;

public interface ComparableEventProbabilityProfile<E extends Comparable<E>,P extends Number> extends EventProbabilityProfile<E, P> {
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being greater than or equal to the supplied event
	 */
	P getProbabilityGreaterThanOrEqualTo(E target) ;
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being less than or equal to the supplied event
	 */
	P getProbabilityLessThanOrEqualTo(E target);
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being greater than the supplied event
	 */
	P getProbabilityGreaterThan(E target);
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being less than the supplied event
	 */
	P getProbabilityLessThan(E target);
	
	int hashCode();
	
	boolean equals(Object obj);

}
