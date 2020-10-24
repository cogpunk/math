package com.cogpunk.math.probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cogpunk.math.NumberOperator;

/**
 * 
 * @param <I> The input Event type for the probability profile
 * @param <E> The Output Event for the probability
 * @param <P> The Probability representation number type
 */
public class EventProbabilityProfileAggegator<I, E, P extends Number> implements EventProbabilityProfile<E, P> {
	
	private EventProbabilityProfile<E, P> probabilityProfile;
	
	private NumberOperator<P> numberOperator;
	
	public EventProbabilityProfileAggegator(
			EventProbabilityProfileAggregationStrategy<I, E> aggregationStrategy, 
			NumberOperator<P> numberOperator,
			EventProbabilityProfile<I,P> ...probabilityProfile) {
		
		this.numberOperator = numberOperator;
		
		this.probabilityProfile = calculateProbabilityProfile(aggregationStrategy, Arrays.asList(probabilityProfile));
	}
	
	public EventProbabilityProfileAggegator(
			EventProbabilityProfileAggregationStrategy<I, E> aggregationStrategy, 
			NumberOperator<P> numberOperator,
			List<EventProbabilityProfile<I,P>> probabilityProfiles) {
		
		this.numberOperator = numberOperator;
		
		this.probabilityProfile = calculateProbabilityProfile(aggregationStrategy, probabilityProfiles);
	}
	

	@Override
	public P getProbability(E event) {
		return probabilityProfile.getProbability(event);
	}
	
	/**
	 * @param aggregationStrategy The strategy to use to aggregate the results
	 * @param iteration The number of the iteration (as in the index of the dice to iterate over 
	 * @param dice The sets of dice
	 * @return
	 */
	protected EventProbabilityProfile<E, P> calculateProbabilityProfile(
			EventProbabilityProfileAggregationStrategy<I, E> aggregationStrategy, 
			List<EventProbabilityProfile<I,P>> probabilityProfiles) {
		
		
		List<EventProbability<E,P>> totalAggregates = new ArrayList<EventProbability<E,P>>();
		List<EventProbability<I,P>> previousDiceResultProbabilities = new ArrayList<EventProbability<I,P>>();
		
		aggregate(totalAggregates, previousDiceResultProbabilities, aggregationStrategy, 0, probabilityProfiles);
		
		// sum all the aggregates together
		
		Map<E, P> profile = new HashMap<E, P>();
		
		for (EventProbability<E,P> result : totalAggregates) {
			if (!profile.containsKey(result.getEvent())) {
				profile.put(result.getEvent(), result.getProbability());
			} else {
				profile.put(result.getEvent(), numberOperator.add(profile.get(result.getEvent()), result.getProbability()));
			}
		}
		
		
		return new SimpleProbabilityProfileImpl<E, P>(profile);
		
		
		
	}
	
	protected void aggregate(
			List<EventProbability<E,P>> totalAggregates, 
			List<EventProbability<I,P>> previousDiceResultProbabilities, 
			EventProbabilityProfileAggregationStrategy<I, E> aggregationStrategy, 
			int iter, 
			List<EventProbabilityProfile<I,P>> probabilityProfiles) {
		
		EventProbabilityProfile<I,P> currentProfile = probabilityProfiles.get(iter);
		
		for (I result : currentProfile.map().keySet()) {
			
			List<EventProbability<I,P>> allDiceResultProbabilities = new ArrayList<EventProbability<I,P>>();
			allDiceResultProbabilities.addAll(previousDiceResultProbabilities);
			allDiceResultProbabilities.add(new EventProbability<I,P>(result, currentProfile.getProbability(result)));
			
			// If there are mode dice to roll, the do so by recusion
			
			if (iter < probabilityProfiles.size()-1) {
				aggregate(totalAggregates, allDiceResultProbabilities, aggregationStrategy, iter+1, probabilityProfiles);
			} else {
				
				// if there are no more dice to roll, then aggregate
				
				List<I> thisRollResults = new ArrayList<I>();
				
				for (EventProbability<I,P> r : allDiceResultProbabilities) {
					thisRollResults.add(r.getEvent());
				}
				
				E finalResult = aggregationStrategy.aggregate(thisRollResults);
				
				P thisRollProbability = null;
				
				for (EventProbability<I,P> r : allDiceResultProbabilities) {
					
					if (thisRollProbability == null) {
						thisRollProbability = r.getProbability();
					} else {
						thisRollProbability =  numberOperator.multiply(thisRollProbability, r.getProbability());
					}
					
					
				}
				
				totalAggregates.add(new EventProbability<E,P>(finalResult, thisRollProbability));				
				
			}
			
		}
		
		
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((probabilityProfile == null) ? 0 : probabilityProfile.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventProbabilityProfileAggegator<I, E, P> other = (EventProbabilityProfileAggegator<I, E, P>) obj;
		if (probabilityProfile == null) {
			if (other.map() != null)
				return false;
		} else if (!map().equals(other.map()))
			return false;
		return true;
	}


	@Override
	public Map<E, P> map() {
		return probabilityProfile.map();
	}


	@Override
	public String toString() {
		return "ProbabilityProfileAggegator [probabilityProfile=" + probabilityProfile + "]";
	}

	
	

}
