package com.cogpunk.math.probability;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EventLessThanSelectorTest {

private EventProbabilityProfile<Integer, Fraction> profile;
	
	@Before
	public void setUp() {
		
		Map<Integer, Fraction> map = new HashMap<Integer, Fraction>();
		map.put(1, new Fraction(1,6));
		map.put(2, new Fraction(1,6));
		map.put(3, new Fraction(1,6));
		map.put(4, new Fraction(1,6));
		map.put(5, new Fraction(1,6));
		map.put(6, new Fraction(1,6));
		
		profile = new SimpleProbabilityProfileImpl<Integer, Fraction>(map);	
		
	}

	@Test
	public void testSelectEventsFromLower() {
		
		Set<Integer> set = new EventLessThanSelector<Integer, Fraction>(-1).selectEvents(profile);
		
		assertEquals(new HashSet<Integer>(), set);
	}
	
	@Test
	public void testSelectEventsFromMiddle() {
		
		Set<Integer> expectedSet = new HashSet<Integer>();
		expectedSet.add(1);
		expectedSet.add(2);
		
		Set<Integer> set = new EventLessThanSelector<Integer, Fraction>(3).selectEvents(profile);
		
		assertEquals(expectedSet, set);
		
	}
	
	@Test
	public void testSelectEventsFromHigher() {
		Set<Integer> set = new EventLessThanSelector<Integer, Fraction>(7).selectEvents(profile);
		
		assertEquals(profile.map().keySet(), set);
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(EventLessThanSelector.class).verify();
		
	}


}
