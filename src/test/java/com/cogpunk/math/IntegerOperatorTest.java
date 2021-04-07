package com.cogpunk.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;


public class IntegerOperatorTest {
	
	private IntegerOperator operator;

	@Before
	public void setUp() {
		operator = new IntegerOperator();
	}

	@Test
	public void testAdd() {
		
		assertEquals(3, operator.add(1, 2));
		assertEquals(1, operator.add(-1, 2));
		
	}
	
	@Test
	public void testSubtract() {
		
		assertEquals(1, operator.subtract(2, 1));
		assertEquals(3, operator.subtract(2, -1));
		assertEquals(-3, operator.subtract(2, 5));
		
	}
	
	@Test
	public void testMultiply() {
		
		assertEquals(2, operator.multiply(2, 1));
		assertEquals(8, operator.multiply(2, 4));
		assertEquals(-8, operator.multiply(2, -4));
		
		
	}
	
	@Test
	public void testDivide() {
		
		assertEquals(2, operator.divide(2, 1));
		assertEquals(2, operator.divide(10, 4));
		assertEquals(-3, operator.divide(22, -7));
		
	}
	
	@Test
	public void testCast() {
		assertEquals(3, operator.cast(3.5));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(IntegerOperator.class).verify();
		
	}

}
