package com.cogpunk.math.probability;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Implementation of VariableZeroHandler for events of type Integer
 */
public class VariableIntegerZeroHandler<P extends Number> implements VariableZeroHandler<Integer, P> {

	@Override
	public void handleZeroRepeats(List<EventProbabilityProfile<Integer, P>> profiles,
			EventProbabilityProfile<Integer, P> repeatProbabilityProfile) {
		
		Map<Integer,P> modProbProf = new HashMap<Integer,P>();
		modProbProf.put(0, repeatProbabilityProfile.getProbability(0));
		profiles.add(new SimpleProbabilityProfileImpl<Integer,P>(modProbProf));
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		return (other instanceof VariableIntegerZeroHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	

}
