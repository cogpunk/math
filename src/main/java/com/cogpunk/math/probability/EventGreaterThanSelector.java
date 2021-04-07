package com.cogpunk.math.probability;

import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Selector for identifying events 'greater than' a given, as defined by Comparable, from a given profile
 * 
 * @param <E> The event type
 * @param <P> The probability type
 */
public class EventGreaterThanSelector<E extends Comparable<E>, P extends Number> implements EventSelector<E, P> {
	
	private final E threshold;
	
	public EventGreaterThanSelector(E threshold) {
		this.threshold = threshold;
	}

	@Override
	public Set<E> selectEvents(EventProbabilityProfile<E, P> profile) {
		
		TreeMap<E,P> map = new TreeMap<E,P>(profile.map());
		
		return map.tailMap(threshold, false).keySet();
		
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EventGreaterThanSelector)) {
			return false;
		}
		EventGreaterThanSelector<?, ?> castOther = (EventGreaterThanSelector<?, ?>) other;
		return new EqualsBuilder().append(threshold, castOther.threshold).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(threshold).toHashCode();
	}
		

	
}
