package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;
import com.cogpunk.math.probability.ComparableEventProbabilityProfileImpl;

public class ComparableEventProbabilityProfileImplTest {
	
	private ComparableEventProbabilityProfileImpl<Integer, Fraction> profile;
	
	
	@Before 
	public void before() {
		
		Fraction onesixth = new Fraction(1,6);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		
		for (int n= 1; n <= 6; n++ ) {
			map.put(n,  onesixth);
		}
		
		profile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());

		
	}
	

	@Test
	public void testResultProbabilityProfileMapOfIntegerFraction() {
		
		TreeMap<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		Fraction onesixth = new Fraction(1,6);
		
		for (int n = 1; n <=6; n++) {
			map.put(n, onesixth);
		}
		
		ComparableEventProbabilityProfileImpl<Integer, Fraction> testprofile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		assertEquals(profile, testprofile);
		assertEquals(profile.hashCode(), testprofile.hashCode());
		assertEquals(profile.toString(), testprofile.toString());
		
	}
	

	@Test
	public void testGetProbability() {
		assertEquals(new Fraction(1,6), profile.getProbability(6));
	}

	@Test
	public void testGetProbabilityGreaterThanOrEqualTo() {
		
		assertEquals(new Fraction(1,2), profile.getProbabilityGreaterThanOrEqualTo(4));
		assertEquals(new Fraction(1,1), profile.getProbabilityGreaterThanOrEqualTo(1));
		assertEquals(new Fraction(1,6), profile.getProbabilityGreaterThanOrEqualTo(6));
		
	}

	@Test
	public void testGetProbabilityLessThanOrEqualTo() {
		
		assertEquals(new Fraction(2,3), profile.getProbabilityLessThanOrEqualTo(4));
		assertEquals(new Fraction(1,6), profile.getProbabilityLessThanOrEqualTo(1));
		assertEquals(new Fraction(1,1), profile.getProbabilityLessThanOrEqualTo(6));
	}

	@Test
	public void testGetProbabilityGreaterThan() {
		assertEquals(new Fraction(6,6), profile.getProbabilityGreaterThan(0));
		assertEquals(new Fraction(1,3), profile.getProbabilityGreaterThan(4));
		assertEquals(new Fraction(5,6), profile.getProbabilityGreaterThan(1));
		assertEquals(new Fraction(0,6), profile.getProbabilityGreaterThan(6));
		
	}

	@Test
	public void testGetProbabilityLessThan() {
		assertEquals(new Fraction(1,2), profile.getProbabilityLessThan(4));
		assertEquals(new Fraction(0,6), profile.getProbabilityLessThan(1));
		assertEquals(new Fraction(5,6), profile.getProbabilityLessThan(6));
		assertEquals(new Fraction(6,6), profile.getProbabilityLessThan(8));
	}

}
