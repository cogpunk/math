package com.cogpunk.math.probability;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * A simple implementation of the ProbabilityProfile
 * 
 * @param <E> The Event
 * @param <P> The probability of the even occurring
 */
public class SimpleProbabilityProfileImpl<E,P extends Number> implements EventProbabilityProfile<E, P> {

	protected TreeMap<E, P> profile = new TreeMap<E, P>();
	
	
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
	public String toString() {
		return "SimpleProbabilityProfileImpl [profile=" + profile + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof SimpleProbabilityProfileImpl)) {
			return false;
		}
		SimpleProbabilityProfileImpl<?,?> castOther = (SimpleProbabilityProfileImpl<?,?>) other;
		return new EqualsBuilder().append(profile, castOther.profile).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(profile).toHashCode();
	}
	
	

}
