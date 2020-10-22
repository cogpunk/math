package com.cogpunk.math.probability;

import java.util.HashMap;
import java.util.Map;

import com.cogpunk.math.NumberOperator;

/**
 * Inverts the probability of all the events. For example, 90% becomes 10%
 * 
 */
public class ProbabilityProfileInverter<E, P extends Number> implements ProbabilityProfile<E, P> {
	
	private Map<E, P> map;
	
	/**
	 * @param profile The input source profile
	 * @param operator Suitable for manipulating the probability
	 */
	public ProbabilityProfileInverter(ProbabilityProfile<E, P> profile, NumberOperator<P> operator) {
		
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

}
