package com.cogpunk.math.probability;

public interface ComparableEventProbabilityProfile<E extends Comparable<E>,P extends Number> extends EventProbabilityProfile<E, P> {
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being greater than or equal to the supplied event
	 */
	public P getProbabilityGreaterThanOrEqualTo(E target) ;
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being less than or equal to the supplied event
	 */
	public P getProbabilityLessThanOrEqualTo(E target);
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being greater than the supplied event
	 */
	public P getProbabilityGreaterThan(E target);
	
	/**
	 * @param target The target to compare to
	 * @return The probability of the event being less than the supplied event
	 */
	public P getProbabilityLessThan(E target);
	
	public int hashCode();
	
	public boolean equals(Object obj);

}
