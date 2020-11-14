package com.cogpunk.math.probability;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ConditionalReevaluationProbabilityProfileTest {
	
	private EventProbabilityProfile<Integer, Fraction> profile;
	
	private EventSelector<Integer, Fraction> selector;

	@Before
	public void setUp() throws Exception {
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,6));
		map.put(2, new Fraction(1,6));
		map.put(3, new Fraction(1,6));
		map.put(4, new Fraction(1,6));
		map.put(5, new Fraction(1,6));
		map.put(6, new Fraction(1,6));
		
		profile = new SimpleProbabilityProfileImpl<Integer, Fraction>(map);
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		
		selector = new EventIntersectionSelectorImpl<Integer, Fraction>(set);
		
	}

	@Test
	public void testZeroIterations() {
		
		ConditionalReevaluationProbabilityProfile<Integer, Fraction> reeval = 
				new ConditionalReevaluationProbabilityProfile<Integer, Fraction>(profile, selector, 0, new FractionOperator());
		
		assertEquals(profile.map(), reeval.map());
		
	}
	
	@Test
	public void testOneIterations() {
		
		Map<Integer, Fraction> expectedMap = new HashMap<Integer, Fraction>();
		expectedMap.put(1, new Fraction(1,36));
		expectedMap.put(2, new Fraction(7,36));
		expectedMap.put(3, new Fraction(7,36));
		expectedMap.put(4, new Fraction(7,36));
		expectedMap.put(5, new Fraction(7,36));
		expectedMap.put(6, new Fraction(7,36));
		
		ConditionalReevaluationProbabilityProfile<Integer, Fraction> reeval = 
				new ConditionalReevaluationProbabilityProfile<Integer, Fraction>(profile, selector, 1, new FractionOperator());
		
		
		assertEquals(expectedMap, reeval.map());
	}
	
	@Test
	public void testTwoIterations() {
		
		Map<Integer, Fraction> expectedMap = new HashMap<Integer, Fraction>();
		expectedMap.put(1, new Fraction(1,216));
		expectedMap.put(2, new Fraction(43,216));
		expectedMap.put(3, new Fraction(43,216));
		expectedMap.put(4, new Fraction(43,216));
		expectedMap.put(5, new Fraction(43,216));
		expectedMap.put(6, new Fraction(43,216));
		
		ConditionalReevaluationProbabilityProfile<Integer, Fraction> reeval = 
				new ConditionalReevaluationProbabilityProfile<Integer, Fraction>(profile, selector, 2, new FractionOperator());
		
		
		assertEquals(expectedMap, reeval.map());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(ConditionalReevaluationProbabilityProfile.class).verify();
		
	}

}
