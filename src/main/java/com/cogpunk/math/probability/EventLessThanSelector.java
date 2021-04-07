package com.cogpunk.math.probability;

import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Selectors for defining those less than the defined event, as defined by the comparable
 * 
 * @param <E> Event type
 * @param <P> Probability type
 */
public class EventLessThanSelector <E extends Comparable<E>, P extends Number> implements EventSelector<E, P> {
	
	private final E threshold;
	
	public EventLessThanSelector(E threshold) {
		this.threshold = threshold;
	}

	@Override
	public Set<E> selectEvents(EventProbabilityProfile<E, P> profile) {
		
		TreeMap<E,P> map = new TreeMap<E,P>(profile.map());
		
		return map.headMap(threshold, false).keySet();
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EventLessThanSelector)) {
			return false;
		}
		EventLessThanSelector<?, ?> castOther = (EventLessThanSelector<?, ?>) other;
		return new EqualsBuilder().append(threshold, castOther.threshold).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(threshold).toHashCode();
	}
		

}

