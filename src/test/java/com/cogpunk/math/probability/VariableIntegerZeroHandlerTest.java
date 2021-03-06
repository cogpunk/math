package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class VariableIntegerZeroHandlerTest {

	@Test
	public void testHandleZeroRepeats() {
		
		List<EventProbabilityProfile<Integer, Fraction>> profiles = new ArrayList<EventProbabilityProfile<Integer, Fraction>>();
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		Fraction f = new Fraction(1,3);
		map.put(0, f);
		
		EventProbabilityProfile<Integer, Fraction> p = new SimpleProbabilityProfileImpl<Integer, Fraction>(map);
		
		VariableIntegerZeroHandler<Fraction> handler = new VariableIntegerZeroHandler<Fraction>();
		
		handler.handleZeroRepeats(profiles, p);
		
		assertEquals(profiles.get(0).getProbability(0), f);
		
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(VariableIntegerZeroHandler.class).verify();
		
	}

}
