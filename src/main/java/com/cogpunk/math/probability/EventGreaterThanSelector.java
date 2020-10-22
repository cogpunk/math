package com.cogpunk.math.probability;

import java.util.Set;
import java.util.TreeMap;

/**
 * Selector for identifying events 'greater than' a given, as defined by Comparable, from a given profile
 * 
 * @param <E> The event type
 * @param <P> The probability type
 */
public class EventGreaterThanSelector<E extends Comparable<E>, P extends Number> implements EventSelector<E, P> {
	
	private E threshold;
	
	public EventGreaterThanSelector(E threshold) {
		this.threshold = threshold;
	}

	@Override
	public Set<E> selectEvents(ProbabilityProfile<E, P> profile) {
		
		TreeMap<E,P> map = new TreeMap<E,P>();
		
		map.putAll(profile.map());
		
		return map.tailMap(threshold, false).keySet();
		
	}
		

}
