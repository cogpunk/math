package com.cogpunk.math.probability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cogpunk.math.NumberOperator;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class VariableProbabilityProfileAggregator<E, P extends Number> implements EventProbabilityProfile<E, P> {
	
	private EventProbabilityProfile<Integer, P> repeatProbabilityProfile;
	
	private EventProbabilityProfile<E, P> probabilityProfile;
	
	private EventProbabilityProfileAggregationStrategy<E, E> aggregationStrategy; 
	
	private NumberOperator<P> numberOperator;
	
	private VariableZeroHandler<E, P> variableZeroHandler;

	public VariableProbabilityProfileAggregator(EventProbabilityProfile<Integer, P> repeatProbabilityProfile,
			EventProbabilityProfileAggregationStrategy<E, E> aggregationStrategy, 
			NumberOperator<P> numberOperator,
			VariableZeroHandler<E, P> variableZeroHandler,
			EventProbabilityProfile<E,P> probabilityProfile) {
		super();
		this.repeatProbabilityProfile = repeatProbabilityProfile;
		this.aggregationStrategy = aggregationStrategy;
		this.numberOperator = numberOperator;
		this.variableZeroHandler = variableZeroHandler;
		
		this.probabilityProfile = calculateProbabilityProfile(probabilityProfile);
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventProbabilityProfile<E, P> calculateProbabilityProfile(EventProbabilityProfile<E, P> probabilityProfile) {
		
		List<EventProbabilityProfile<E, P>> aggrProfs= new ArrayList<EventProbabilityProfile<E, P>>();
		
		for (Integer r : repeatProbabilityProfile.map().keySet()) {
			
			P prob = repeatProbabilityProfile.getProbability(r);
			
			if (r < 0) {
				
				throw new IllegalArgumentException("The number of repeats cannot be < 0");
				
			} else if (r == 0) {
			
				
				variableZeroHandler.handleZeroRepeats(aggrProfs, repeatProbabilityProfile);
				
				
			} else {
			
				List<EventProbabilityProfile<E, P>> profs = new ArrayList<EventProbabilityProfile<E, P>>();
				
				for (int n = 0; n < r; n++) {
					profs.add(probabilityProfile);
				}
				
				EventProbabilityProfile<E, P> thisProbProf = new EventProbabilityProfileAggregator(aggregationStrategy, numberOperator, profs);
	
				// Change probabilities based on probability of this occurring
				
				Map<E,P> modProbProf = new HashMap<E,P>();
				
				for (E e : thisProbProf.map().keySet()) { 
					modProbProf.put(e, numberOperator.multiply(thisProbProf.getProbability(e), prob));
				}
			
				aggrProfs.add(new SimpleProbabilityProfileImpl<E,P>(modProbProf));
			}
			
		}
		
		return  assembleProbabilityProfile(aggrProfs);
		
	}
	
	private EventProbabilityProfile<E, P>  assembleProbabilityProfile(List<EventProbabilityProfile<E, P>>  aggrProfs) {
		Map<E,P> map = new HashMap<E,P>();
		
		for (EventProbabilityProfile<E, P> prof : aggrProfs) {
			for (E e : prof.map().keySet()) {
				P prob = prof.getProbability(e);
				
				if (map.containsKey(e)) {
					map.put(e, numberOperator.add(map.get(e), prob));
				} else {
					map.put(e, prob);
				}
				
			}
		}
		
		return  new SimpleProbabilityProfileImpl<E, P>(map);
	}


	@Override
	public P getProbability(E event) {
		return probabilityProfile.getProbability(event);
	}
	
	@Override
	public Map<E, P> map() {
		return probabilityProfile.map();
	}



	@Override
	public String toString() {
		return "VariableProbabilityProfileAggreggator [repeatProbabilityProfile=" + repeatProbabilityProfile
				+ ", probabilityProfile="
				+ probabilityProfile + ", aggregationStrategy=" + aggregationStrategy + ", numberOperator="
				+ numberOperator + "]";
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof VariableProbabilityProfileAggregator)) {
			return false;
		}
		VariableProbabilityProfileAggregator<?,?> castOther = (VariableProbabilityProfileAggregator<?,?>) other;
		return new EqualsBuilder().append(repeatProbabilityProfile, castOther.repeatProbabilityProfile)
				.append(probabilityProfile, castOther.probabilityProfile)
				.append(aggregationStrategy, castOther.aggregationStrategy)
				.append(numberOperator, castOther.numberOperator)
				.append(variableZeroHandler, castOther.variableZeroHandler).isEquals();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(repeatProbabilityProfile).append(probabilityProfile)
				.append(aggregationStrategy).append(numberOperator).append(variableZeroHandler).toHashCode();
	}

}
