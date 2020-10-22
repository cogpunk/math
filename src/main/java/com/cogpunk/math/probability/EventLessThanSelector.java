package com.cogpunk.math.probability;

import java.util.Set;
import java.util.TreeMap;

/**
 * Selectors for defining those less than the defined event, as defined by the comparable
 * 
 * @param <E> Event type
 * @param <P> Probability type
 */
public class EventLessThanSelector <E extends Comparable<E>, P extends Number> implements EventSelector<E, P> {
	
	private E threshold;
	
	public EventLessThanSelector(E threshold) {
		this.threshold = threshold;
	}

	@Override
	public Set<E> selectEvents(ProbabilityProfile<E, P> profile) {
		
		TreeMap<E,P> map = new TreeMap<E,P>();
		
		map.putAll(profile.map());
		
		return map.headMap(threshold, false).keySet();
		
	}
		

}

