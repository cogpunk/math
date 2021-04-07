package com.cogpunk.math.probability;

import java.util.Set;

public interface EventSelector<E,P extends Number> {
	
	/**
	 * @param profile The profile to examine to find matching events
	 * @return The Events which meet the conditional re-evaluation
	 */
    Set<E> selectEvents(EventProbabilityProfile<E, P> profile);

}
