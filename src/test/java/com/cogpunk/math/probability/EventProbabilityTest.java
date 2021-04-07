package com.cogpunk.math.probability;

import org.junit.Assert;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EventProbabilityTest {

	@Test
	public void testHashCode() {
		
		Object e = new Object();
		Integer i = 1;
		
		EventProbability<Object, Integer> p1 = new EventProbability<Object, Integer> (e,i);
		EventProbability<Object, Integer> p2 = new EventProbability<Object, Integer> (e,i);
		
		Assert.assertEquals(p1.hashCode(), p2.hashCode());
		
		
	}

	@Test
	public void testGetEvent() {
		Object e = new Object();
		Integer i = 1;
		
		EventProbability<Object, Integer> p = new EventProbability<Object, Integer> (e,i);
		
		Assert.assertEquals(e, p.getEvent());
	}

	@Test
	public void testGetProbability() {
		Object e = new Object();
		Integer i = 1;
		
		EventProbability<Object, Integer> p = new EventProbability<Object, Integer> (e,i);
		
		Assert.assertEquals(i, p.getProbability());
	}

	@Test
	public void testEqualsObject() {
		Object e = new Object();
		Integer i = 1;
		
		EventProbability<Object, Integer> p1 = new EventProbability<Object, Integer> (e,i);
		EventProbability<Object, Integer> p2 = new EventProbability<Object, Integer> (e,i);
		
		Assert.assertEquals(p1, p2);
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(EventProbability.class).verify();
		
	}

}
