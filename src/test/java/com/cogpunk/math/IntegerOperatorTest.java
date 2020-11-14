package com.cogpunk.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;


public class IntegerOperatorTest {
	
	private IntegerOperator operator;

	@Before
	public void setUp() throws Exception {
		operator = new IntegerOperator();
	}

	@Test
	public void testAdd() {
		
		assertEquals(3, (int) operator.add(1, 2));
		assertEquals(1, (int) operator.add(-1, 2));
		
	}
	
	@Test
	public void testSubtract() {
		
		assertEquals(1, (int) operator.subtract(2, 1));
		assertEquals(3, (int) operator.subtract(2, -1));
		assertEquals(-3, (int) operator.subtract(2, 5));
		
	}
	
	@Test
	public void testMultiply() {
		
		assertEquals(2, (int) operator.multiply(2, 1));
		assertEquals(8, (int) operator.multiply(2, 4));
		assertEquals(-8, (int) operator.multiply(2, -4));
		
		
	}
	
	@Test
	public void testDivide() {
		
		assertEquals(2, (int) operator.divide(2, 1));
		assertEquals(2, (int) operator.divide(10, 4));
		assertEquals(-3, (int) operator.divide(22, -7));
		
	}
	
	@Test
	public void testCast() {
		assertEquals(3, (int) operator.cast(3.5));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(IntegerOperator.class).verify();
		
	}

}
