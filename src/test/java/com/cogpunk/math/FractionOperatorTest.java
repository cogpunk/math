package com.cogpunk.math;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class FractionOperatorTest {
	
	private FractionOperator operator;

	@Before
	public void setUp() {
		operator = new FractionOperator();
	}

	@Test
	public void testAdd() {
		assertEquals(new Fraction(5,6), operator.add(new Fraction(1,2), new Fraction(1,3)));
		assertEquals(new Fraction(-1,6), operator.add(new Fraction(-1,2), new Fraction(1,3)));
		assertEquals(new Fraction(-1,6), operator.add(new Fraction(1,-2), new Fraction(1,3)));
	}

	@Test
	public void testSubtract() {
		assertEquals(new Fraction(1,6), operator.subtract(new Fraction(1,2), new Fraction(1,3)));
		assertEquals(new Fraction(-5,6), operator.subtract(new Fraction(-1,2), new Fraction(1,3)));
		
	}

	@Test
	public void testMultiply() {
		assertEquals(new Fraction(1,6), operator.multiply(new Fraction(1,2), new Fraction(1,3)));
		assertEquals(new Fraction(-1,6), operator.multiply(new Fraction(-1,2), new Fraction(1,3)));
	}

	@Test
	public void testDivide() {
		assertEquals(new Fraction(3,2), operator.divide(new Fraction(1,2), new Fraction(1,3)));
		assertEquals(new Fraction(-3,2), operator.divide(new Fraction(1,2), new Fraction(-1,3)));
	}

	@Test
	public void testCast() {
		assertEquals(new Fraction(1,1), operator.cast(1));
		assertEquals(new Fraction(1,1), operator.cast(1.0));
		assertEquals(new Fraction(1,2), operator.cast(0.5));
		assertEquals(new Fraction(1,4), operator.cast(0.25));
		assertEquals(new Fraction(1,3), operator.cast(new Fraction(1,3)));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		
		EqualsVerifier.simple().forClass(FractionOperator.class).verify();
		
	}
	

}
