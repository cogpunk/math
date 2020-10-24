package com.cogpunk.math.probability;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A simple implementation of the ProbabilityProfile
 * 
 * @param <E>
 * @param <P>
 */
public class SimpleProbabilityProfileImpl<E,P extends Number> implements ProbabilityProfile<E, P> {

	private TreeMap<E, P> profile = new TreeMap<E, P>();
	
	
	/**
	 * 
	 * @param profile Source profile to copy
	 */
	public SimpleProbabilityProfileImpl(Map<E, P> profile) {
		this.profile.putAll(profile);
	}
	
	/**
	 * @return The probability of the supplied event
	 */
	@Override
	public P getProbability(E event) {
		
		return profile.get(event);
	}

	/**
	 * @return All events with their probabilities, order by the event
	 */
	@Override
	public SortedMap<E, P> map() {
		return Collections.unmodifiableSortedMap(profile);
	}
	
	protected TreeMap<E, P> internalMap() {
		return profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		SimpleProbabilityProfileImpl other = (SimpleProbabilityProfileImpl) obj;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleProbabilityProfileImpl [profile=" + profile + "]";
	}
	
	

}
