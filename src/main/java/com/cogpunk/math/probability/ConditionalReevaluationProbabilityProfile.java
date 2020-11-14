package com.cogpunk.math.probability;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cogpunk.math.NumberOperator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Conditionally re-evaluates the probabilities under conditions defined by the supplied the Event selector
 * 
 * An example would be a conditional re-roll of  dice
 */
public class ConditionalReevaluationProbabilityProfile<E,P extends Number> implements EventProbabilityProfile<E, P> {
	
	private EventProbabilityProfile<E,P> profile;

	/**
	 * @param baseProfile The base, source profile
	 * @param selector  The event selector that determines which event are to be reevaluated
	 * @param reevaluationCount The maximum number of times a reevaluation is to occur
	 * @param numberOperator The operator for the probability number type
	 */
	public ConditionalReevaluationProbabilityProfile(EventProbabilityProfile<E, P> baseProfile, EventSelector<E, P> selector, int reevaluationCount, NumberOperator<P> numberOperator) {
		super();
		
		profile = calculate(baseProfile, selector, reevaluationCount, numberOperator);
	}
	
	private EventProbabilityProfile<E,P> calculate(EventProbabilityProfile<E, P> baseProfile, EventSelector<E, P> selector, int reevaluationCount, NumberOperator<P> numberOperator) {
		
		Map<E,P> currentMap = new HashMap<E, P>();
		currentMap.putAll(baseProfile.map());
		
		Set<E> reevalEvents = selector.selectEvents(baseProfile);
		
		for (int n = 0; n < reevaluationCount; n++) {

			P totalReevalProb = numberOperator.cast(0);
			
			for (E event : reevalEvents) {
				P prob = currentMap.get(event);
				currentMap.remove(event);
				totalReevalProb = numberOperator.add(totalReevalProb, prob);
			}
			
			// Take the base profile, multiply it by the probability of revelaution and add it to the current profile
			
			Map<E,P> reevalMap = new HashMap<E, P>();
			reevalMap.putAll(baseProfile.map());
			
			for (E event : reevalMap.keySet()) {
				
				P prob = numberOperator.multiply(totalReevalProb, reevalMap.get(event));
				
				if (!currentMap.containsKey(event)) {
					currentMap.put(event, prob);
				} else {
					currentMap.put(event, numberOperator.add(prob, currentMap.get(event)));
				}
				
			}
			
		}
		
		return new SimpleProbabilityProfileImpl<E,P>(currentMap);
		
		
	}

	@Override
	public P getProbability(E event) {
		return profile.getProbability(event);
	}

	@Override
	public Map<E, P> map() {
		return profile.map();
	}

	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ConditionalReevaluationProbabilityProfile)) {
			return false;
		}
		ConditionalReevaluationProbabilityProfile<?, ?> castOther = (ConditionalReevaluationProbabilityProfile<?, ?>) other;
		return new EqualsBuilder().append(profile, castOther.profile).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(profile).toHashCode();
	}
	
	
	

}
