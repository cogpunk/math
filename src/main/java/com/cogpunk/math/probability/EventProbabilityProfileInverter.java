package com.cogpunk.math.probability;

import java.util.HashMap;
import java.util.Map;

import com.cogpunk.math.NumberOperator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Inverts the probability of all the events. For example, 90% becomes 10%
 * 
 */
public class EventProbabilityProfileInverter<E, P extends Number> implements EventProbabilityProfile<E, P> {
	
	private Map<E, P> map;
	
	/**
	 * @param profile The input source profile
	 * @param operator Suitable for manipulating the probability
	 */
	public EventProbabilityProfileInverter(EventProbabilityProfile<E, P> profile, NumberOperator<P> operator) {
		
		map = new HashMap<E,P>();
		
		for (E e : profile.map().keySet()) {
			map.put(e, operator.subtract(operator.cast(1), profile.map().get(e)));
		}
		
	}
	

	@Override
	public P getProbability(E event) {
		return map.get(event);
	}

	@Override
	public Map<E, P> map() {
		return map;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EventProbabilityProfileInverter)) {
			return false;
		}
		EventProbabilityProfileInverter<?, ?> castOther = (EventProbabilityProfileInverter<?, ?>) other;
		return new EqualsBuilder().append(map, castOther.map).isEquals();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(map).toHashCode();
	}
	
	

}
