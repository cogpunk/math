package com.cogpunk.math.probability;

import java.util.Set;

public interface EventSelector<E,P extends Number> {
	
	/**
	 * @param profile
	 * @return The Events which meet the conditional re-evaluation
	 */
	public Set<E> selectEvents(EventProbabilityProfile<E,P> profile);

}
