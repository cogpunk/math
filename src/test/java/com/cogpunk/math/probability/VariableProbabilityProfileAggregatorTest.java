package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;
import com.cogpunk.math.IntegerOperator;

import nl.jqno.equalsverifier.EqualsVerifier;

public class VariableProbabilityProfileAggregatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Map<Integer, Fraction> d3map = new HashMap<Integer, Fraction>();
		d3map.put(1, new Fraction(1,3));
		d3map.put(2, new Fraction(1,3));
		d3map.put(3, new Fraction(1,3));
		
		EventProbabilityProfile<Integer, Fraction> d3 = new SimpleProbabilityProfileImpl<Integer, Fraction>(d3map);
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(0, new Fraction(1,3));
		map.put(1, new Fraction(2,3));
		
		EventProbabilityProfile<Integer, Fraction> prof = new SimpleProbabilityProfileImpl<Integer, Fraction>(map);
		
		FractionOperator fractionOperator = new FractionOperator();
		IntegerOperator integerOperator = new IntegerOperator();
		
		VariableProbabilityProfileAggregator<Integer, Fraction> agg = new VariableProbabilityProfileAggregator<Integer, Fraction>(
				d3,
				new EventProbabilityProfileAdditionAggregationStrategy<Integer>(integerOperator),
				fractionOperator,
				new VariableIntegerZeroHandler<Fraction>(),
				prof
		);
		
		Map<Integer, Fraction> expMap = new HashMap<Integer, Fraction>();
		expMap.put(0, new Fraction(13,81));
		expMap.put(1, new Fraction(36,81));
		expMap.put(2, new Fraction(24,81));
		expMap.put(3, new Fraction(8,81));
		
		assertEquals(expMap, agg.map());
				
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(VariableProbabilityProfileAggregator.class).verify();
		
	}

}
