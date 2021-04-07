package com.cogpunk.math.probability;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class SimpleEventProbabilityProfileImplTest {
	
	private Map<String, Integer> map1;
	private Map<String, Integer> map2;

	@Before
	public void setUp() {
		map1 = new HashMap<String, Integer>();
		map1.put("First", 1);
		map1.put("Second", 2);
		map1.put("Third", 3);
		
		map2 = new HashMap<String, Integer>(map1);
	}

	@Test
	public void testHashCode() {
		
		
		SimpleProbabilityProfileImpl<String, Integer> p1 = new SimpleProbabilityProfileImpl<String, Integer> (this.map1);
		SimpleProbabilityProfileImpl<String, Integer> p2 = new SimpleProbabilityProfileImpl<String, Integer> (this.map2);
		
		Assert.assertEquals(p1.hashCode(), p2.hashCode());
		
		
	}


	@Test
	public void testEqualsString() {
		SimpleProbabilityProfileImpl<String, Integer> p1 = new SimpleProbabilityProfileImpl<String, Integer> (this.map1);
		SimpleProbabilityProfileImpl<String, Integer> p2 = new SimpleProbabilityProfileImpl<String, Integer> (this.map2);
		
		Assert.assertEquals(p1, p2);
	}
	
	@Test
	public void testMap() {
		SimpleProbabilityProfileImpl<String, Integer> p1 = new SimpleProbabilityProfileImpl<String, Integer> (this.map1);
		
		Assert.assertEquals(this.map1, new HashMap<String, Integer>(p1.map()));
	}
	
	@Test
	public void testInternalMap() {
		SimpleProbabilityProfileImpl<String, Integer> p1 = new SimpleProbabilityProfileImpl<String, Integer> (this.map1);
		
		Assert.assertEquals(this.map1, new HashMap<String, Integer>(p1.internalMap()));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(SimpleProbabilityProfileImpl.class).verify();
		
	}

}
