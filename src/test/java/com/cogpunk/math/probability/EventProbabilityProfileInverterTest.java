package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;

public class EventProbabilityProfileInverterTest {

	@Test
	public void testInverstion() {

		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,6));
		map.put(2, new Fraction(2,6));
		map.put(3, new Fraction(3,6));
		
		EventProbabilityProfile<Integer, Fraction> inverted = new EventProbabilityProfileInverter<Integer, Fraction>(new SimpleProbabilityProfileImpl<Integer, Fraction>(map), new FractionOperator());
		
		assertEquals(new Fraction(5,6), inverted.getProbability(1));
		assertEquals(new Fraction(4,6), inverted.getProbability(2));
		assertEquals(new Fraction(3,6), inverted.getProbability(3));
		
	}

}
