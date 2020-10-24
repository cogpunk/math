package com.cogpunk.math.probability;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import com.cogpunk.math.FractionOperator;
import com.cogpunk.math.IntegerOperator;
import com.cogpunk.math.probability.ComparableEventProbabilityProfile;
import com.cogpunk.math.probability.ComparableEventProbabilityProfileImpl;
import com.cogpunk.math.probability.ProbabilityProfileAdditionAggregationStrategy;
import com.cogpunk.math.probability.ProbabilityProfileAggegator;

public class ProbabilityProfileAggegatorTest {
	

	@Test
	public void testSingleProbabilityProfile() {
		
		ProbabilityProfile<Integer, Fraction> profile =  createProfile(6);
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
		= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy(new IntegerOperator()), new FractionOperator(), profile);
		
		assertEquals(profile.map(), aggregator.map());
		
	}
	
	@Test
	public void testEqualsHashCode() {
		
		ProbabilityProfile<Integer, Fraction> profile =  createProfile(6);
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator1 
		= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy(new IntegerOperator()), new FractionOperator(), profile);
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator2
		= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy(new IntegerOperator()), new FractionOperator(), profile);
		
		
		assertEquals(aggregator1, aggregator2);
		assertEquals(aggregator1.hashCode(), aggregator2.hashCode());
		
	}
	
	
	@Test
	public void testTwoProbabilityProfileAddition() {
		
		ProbabilityProfile<Integer, Fraction> profile =  createProfile(6);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		
		map.put(2, new Fraction(1,36));
		map.put(3, new Fraction(2,36));
		map.put(4, new Fraction(3,36));
		map.put(5, new Fraction(4,36));
		map.put(6, new Fraction(5,36));
		map.put(7, new Fraction(6,36));
		map.put(8, new Fraction(5,36));
		map.put(9, new Fraction(4,36));
		map.put(10, new Fraction(3,36));
		map.put(11, new Fraction(2,36));
		map.put(12, new Fraction(1,36));
		
		ComparableEventProbabilityProfile<Integer, Fraction> expectedProfile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
			= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()), new FractionOperator(), profile, profile);
		
		assertEquals(expectedProfile.map(), aggregator.map());
	}
	
	@Test
	public void testTwoProbabilityProfileHighest() {
		
		ProbabilityProfile<Integer, Fraction> profile =  createProfile(6);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		
		map.put(1, new Fraction(1,36));
		map.put(2, new Fraction(3,36));
		map.put(3, new Fraction(5,36));
		map.put(4, new Fraction(7,36));
		map.put(5, new Fraction(9,36));
		map.put(6, new Fraction(11,36));
		
		ComparableEventProbabilityProfile<Integer, Fraction> expectedProfile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
			= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileHighestAggregationStrategy<Integer>(), new FractionOperator(), profile, profile);
		
		assertEquals(expectedProfile.map(), aggregator.map());
	}
	
	@Test
	public void testTwoProbabilityProfileLowest() {
		
		ProbabilityProfile<Integer, Fraction> profile = createProfile(6);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		
		map.put(1, new Fraction(11,36));
		map.put(2, new Fraction(9,36));
		map.put(3, new Fraction(7,36));
		map.put(4, new Fraction(5,36));
		map.put(5, new Fraction(3,36));
		map.put(6, new Fraction(1,36));
		
		ComparableEventProbabilityProfile<Integer, Fraction> expectedProfile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
			= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileLowestAggregationStrategy<Integer>(), new FractionOperator(), profile, profile);
		
		assertEquals(expectedProfile.map(), aggregator.map());
	}
	
	@Test
	public void testThreeProbabilityProfileAddition() {
		
		ProbabilityProfile<Integer, Fraction> profile = createProfile(6);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		map.put(3, new Fraction(1,216));
		map.put(4, new Fraction(3,216));
		map.put(5, new Fraction(6,216));
		map.put(6, new Fraction(10,216));
		map.put(7, new Fraction(15,216));
		map.put(8, new Fraction(21,216));
		map.put(9, new Fraction(25,216));
		map.put(10, new Fraction(27,216));
		map.put(11, new Fraction(27,216));
		map.put(12, new Fraction(25,216));
		map.put(13, new Fraction(21,216));
		map.put(14, new Fraction(15,216));
		map.put(15, new Fraction(10,216));
		map.put(16, new Fraction(6,216));
		map.put(17, new Fraction(3,216));
		map.put(18, new Fraction(1,216));
		
		ComparableEventProbabilityProfile<Integer, Fraction> expectedProfile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
		= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()), new FractionOperator(), profile, profile, profile);
		
		assertEquals(expectedProfile.map(), aggregator.map());
	}
	
	@Test
	public void testTwoWeightedCoinsAddition() {
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		map.put(0, new Fraction(1,4));
		map.put(1, new Fraction(3,4));
		ComparableEventProbabilityProfile<Integer, Fraction> profile = new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
		ProbabilityProfileAggegator<Integer, Integer, Fraction> aggregator 
		= new ProbabilityProfileAggegator<Integer, Integer, Fraction>(new ProbabilityProfileAdditionAggregationStrategy<Integer>(new IntegerOperator()), new FractionOperator(), profile, profile);
		
		Map<Integer, Fraction> expectedMap = new TreeMap<Integer, Fraction>();
		expectedMap.put(0, new Fraction(1,16));
		expectedMap.put(1, new Fraction(6,16));
		expectedMap.put(2, new Fraction(9,16));
		
		assertEquals(expectedMap, aggregator.map());
		
		
	}
	
	public ProbabilityProfile<Integer, Fraction> createProfile(int bins) {
		
		Fraction prob = new Fraction(1, bins);
		
		Map<Integer, Fraction> map = new TreeMap<Integer, Fraction>();
		
		for (int n= 1; n <= bins; n++ ) {
			map.put(n,  prob);
		}
		
		return new ComparableEventProbabilityProfileImpl<Integer, Fraction>(map, new FractionOperator());
		
	}

}
