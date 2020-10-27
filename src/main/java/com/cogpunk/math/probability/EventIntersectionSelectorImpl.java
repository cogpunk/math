package com.cogpunk.math.probability;

import java.util.HashSet;
import java.util.Set;

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

}
