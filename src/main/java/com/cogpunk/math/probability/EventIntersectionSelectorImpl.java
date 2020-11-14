package com.cogpunk.math.probability;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Selector for identifying the intersection with the defined set of events.
 * 
 * @param <E> Event type
 * @param <P> Probability type
 */
public class EventIntersectionSelectorImpl<E,P extends Number> implements EventSelector<E, P> {
	
	private Set<E> events = new HashSet<E>();
	
	public EventIntersectionSelectorImpl(Set<E> events) {
		this.events.addAll(events);
	}

	@Override
	public Set<E> selectEvents(EventProbabilityProfile<E, P> profile) {
		Set<E> intersection = new HashSet<E>(events);
		intersection.retainAll(profile.map().keySet());
		return intersection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EventIntersectionSelectorImpl)) {
			return false;
		}
		EventIntersectionSelectorImpl<?, ?> castOther = (EventIntersectionSelectorImpl<?, ?>) other;
		return new EqualsBuilder().append(events, castOther.events).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(events).toHashCode();
	}

}
