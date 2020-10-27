package com.cogpunk.math.probability;

import java.util.List;

/**
 * @param <E> The event type
 * @param <P> The probability
 */
public interface VariableZeroHandler<E, P extends Number> {
	
	/**
	 * Called in situations where the number of evaluations is to be zero
	 * @param profiles The list containing all the probability profiles
	 * @param repeatProbabilityProfile The probability of the the various repeats happening
	 */
	public void handleZeroRepeats(
			List<EventProbabilityProfile<E, P>> profiles,
			EventProbabilityProfile<Integer, P> repeatProbabilityProfile);

}
