package com.cogpunk.math.probability;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProbabilityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHashCode() {
		
		Object e = new Object();
		Integer i = 1;
		
		Probability<Object, Integer> p1 = new Probability<Object, Integer> (e,i);
		Probability<Object, Integer> p2 = new Probability<Object, Integer> (e,i);
		
		Assert.assertEquals(p1.hashCode(), p2.hashCode());
		
		
	}

	@Test
	public void testGetEvent() {
		Object e = new Object();
		Integer i = 1;
		
		Probability<Object, Integer> p = new Probability<Object, Integer> (e,i);
		
		Assert.assertEquals(e, p.getEvent());
	}

	@Test
	public void testGetProbability() {
		Object e = new Object();
		Integer i = 1;
		
		Probability<Object, Integer> p = new Probability<Object, Integer> (e,i);
		
		Assert.assertEquals(i, p.getProbability());
	}

	@Test
	public void testEqualsObject() {
		Object e = new Object();
		Integer i = 1;
		
		Probability<Object, Integer> p1 = new Probability<Object, Integer> (e,i);
		Probability<Object, Integer> p2 = new Probability<Object, Integer> (e,i);
		
		Assert.assertEquals(p1, p2);
	}

}
