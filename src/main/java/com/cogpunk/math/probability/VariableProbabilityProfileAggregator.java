package com.cogpunk.math.probability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cogpunk.math.NumberOperator;

public class VariableProbabilityProfileAggregator<E, P extends Number> implements ProbabilityProfile<E, P> {
	
	private ProbabilityProfile<Integer, P> repeatProbabilityProfile;
	
	private ProbabilityProfile<E, P> probabilityProfile;
	
	private ProbabilityProfileAggregationStrategy<E, E> aggregationStrategy; 
	
	private NumberOperator<P> numberOperator;
	
	private VariableZeroHandler<E, P> variableZeroHandler;

	public VariableProbabilityProfileAggregator(ProbabilityProfile<Integer, P> repeatProbabilityProfile,
			ProbabilityProfileAggregationStrategy<E, E> aggregationStrategy, 
			NumberOperator<P> numberOperator,
			VariableZeroHandler<E, P> variableZeroHandler,
			ProbabilityProfile<E,P> probabilityProfile) {
		super();
		this.repeatProbabilityProfile = repeatProbabilityProfile;
		this.aggregationStrategy = aggregationStrategy;
		this.numberOperator = numberOperator;
		this.variableZeroHandler = variableZeroHandler;
		
		this.probabilityProfile = calculateProbabilityProfile(probabilityProfile);
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ProbabilityProfile<E, P> calculateProbabilityProfile(ProbabilityProfile<E, P> probabilityProfile) {
		
		List<ProbabilityProfile<E, P>> aggrProfs= new ArrayList<ProbabilityProfile<E, P>>();
		
		for (Integer r : repeatProbabilityProfile.map().keySet()) {
			
			P prob = repeatProbabilityProfile.getProbability(r);
			
			if (r < 0) {
				
				throw new IllegalArgumentException("The number of repeats cannot be < 0");
				
			} else if (r == 0) {
			
				
				variableZeroHandler.handleZeroRepeats(aggrProfs, repeatProbabilityProfile);
				
				
			} else {
			
				List<ProbabilityProfile<E, P>> profs = new ArrayList<ProbabilityProfile<E, P>>();
				
				for (int n = 0; n < r; n++) {
					profs.add(probabilityProfile);
				}
				
				ProbabilityProfile<E, P> thisProbProf = new ProbabilityProfileAggegator(aggregationStrategy, numberOperator, profs);
	
				// Change probabilities based on probability of this occurring
				
				Map<E,P> modProbProf = new HashMap<E,P>();
				
				for (E e : thisProbProf.map().keySet()) { 
					modProbProf.put(e, numberOperator.multiply(thisProbProf.getProbability(e), prob));
				}
			
				aggrProfs.add(new SimpleProbabilityProfileImpl<E,P>(modProbProf));
			}
			
		}
		
		// Now simply add the probabilities together
		
		Map<E,P> map = new HashMap<E,P>();
		
		for (ProbabilityProfile<E, P> prof : aggrProfs) {
			for (E e : prof.map().keySet()) {
				P prob = prof.getProbability(e);
				
				if (map.containsKey(e)) {
					map.put(e, numberOperator.add(map.get(e), prob));
				} else {
					map.put(e, prob);
				}
				
			}
		}
		
		return  new SimpleProbabilityProfileImpl(map);
		
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
	
	
	
	

}
