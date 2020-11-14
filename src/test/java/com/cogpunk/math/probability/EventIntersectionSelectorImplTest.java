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

public class EventIntersectionSelectorImplTest {

	private EventProbabilityProfile<Integer, Fraction> profile;
	
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
		
		
	}

	@Test
	public void test() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		
		EventSelector<Integer, Fraction> selector = new EventIntersectionSelectorImpl<Integer, Fraction>(set);
		
		Set<Integer> selectedSet = selector.selectEvents(profile);
		
		Set<Integer> expectedSet = new HashSet<Integer>();
		expectedSet.add(1);
		expectedSet.add(3);
		expectedSet.add(5);
		
		assertEquals(expectedSet, selectedSet);
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(EventIntersectionSelectorImpl.class).verify();
		
	}

}
