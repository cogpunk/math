package com.cogpunk.math.probability;

import java.util.Collection;
import java.util.Map;

import com.cogpunk.math.NumberOperator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * A ProbabilityProfile for Comparable Events
 */
public class ComparableEventProbabilityProfileImpl<E extends Comparable<E>, P extends Number> extends SimpleProbabilityProfileImpl<E, P> implements ComparableEventProbabilityProfile<E, P> {
	
	private NumberOperator<P> numberOperator ;
	
	/**
	 * @param profile The source profile to copy
	 * @param numberOperator An oprator suability for manipulating  the probabilities
	 */
	public ComparableEventProbabilityProfileImpl(Map<E, P> profile, NumberOperator<P> numberOperator) {
		super(profile);
		
		this.numberOperator = numberOperator;
	}
	
	@Override
	public P getProbabilityGreaterThanOrEqualTo(E target) {
		
		return sumProbabilities(map().tailMap(target).values());
		
	}
	
	@Override
	public P getProbabilityLessThanOrEqualTo(E target) {
		
		return sumProbabilities(internalMap().headMap(target, true).values());
		
	}
	
	@Override
	public P getProbabilityGreaterThan(E target) {
		return sumProbabilities(internalMap().tailMap(target, false).values());
	}
	
	@Override
	public P getProbabilityLessThan(E target) {
		return sumProbabilities(internalMap().headMap(target, false).values());
	}
	
	/**
	 * @param probabilities The values to add
	 * @return All of the probabilities added together
	 */
	private P sumProbabilities(Collection<P> probabilities) {
		P probability = numberOperator.cast(0);
		
		for (P f : probabilities) {
			probability = numberOperator.add(f, probability);
			
		}
		
		return probability;
	}

	@Override
	public String toString() {
		return "NumberProbabilityProfileImpl [profile=" + map() + "]";
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ComparableEventProbabilityProfileImpl)) {
			return false;
		}
		ComparableEventProbabilityProfileImpl<?, ?> castOther = (ComparableEventProbabilityProfileImpl<?, ?>) other;
		return new EqualsBuilder()
				.append(profile, castOther.profile)
				.append(numberOperator, castOther.numberOperator)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(numberOperator).append(profile).toHashCode();
	}

}
