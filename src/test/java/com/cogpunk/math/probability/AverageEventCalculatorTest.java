package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;

public class AverageEventCalculatorTest {

	@Test
	public void testMode() {
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,3));
		map.put(2, new Fraction(2,3));
		map.put(3, new Fraction(2,3));
		
		AverageEventCalculator<Integer, Fraction> calc = new AverageEventCalculator<Integer, Fraction>(new FractionOperator());
		
		assertEquals((Integer ) 2, calc.mode(new SimpleProbabilityProfileImpl<Integer, Fraction>(map)));
		
		map.put(3, new Fraction(3,3));
		
		assertEquals((Integer ) 3, calc.mode(new SimpleProbabilityProfileImpl<Integer, Fraction>(map)));
		
	}

	@Test
	public void testMedian() {
	
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,3));
		map.put(2, new Fraction(2,3));
		map.put(3, new Fraction(2,3));
		
		AverageEventCalculator<Integer, Fraction> calc = new AverageEventCalculator<Integer, Fraction>(new FractionOperator());
		
		assertEquals((Integer ) 2, calc.median(new SimpleProbabilityProfileImpl<Integer, Fraction>(map)));
		
		map.put(3, new Fraction(3,3));
		
		assertEquals((Integer ) 2, calc.median(new SimpleProbabilityProfileImpl<Integer, Fraction>(map)));
		
		map.put(3, new Fraction(4,3));
		
		assertEquals((Integer ) 3, calc.median(new SimpleProbabilityProfileImpl<Integer, Fraction>(map)));
		
	}

	@Test
	public void testCalculateTotalProbability() {
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,3));
		map.put(2, new Fraction(2,3));
		map.put(3, new Fraction(2,3));
		
		EventProbabilityProfile<Integer, Fraction> profile = new SimpleProbabilityProfileImpl<Integer, Fraction>(map);
		
		AverageEventCalculator<Integer, Fraction> calc = new AverageEventCalculator<Integer, Fraction>(new FractionOperator());
		
		assertEquals(new Fraction(5,3), calc.calculateTotalProbability(profile));
		
	}

}
