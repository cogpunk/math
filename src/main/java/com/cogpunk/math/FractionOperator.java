package com.cogpunk.math;

import org.apache.commons.math3.fraction.Fraction;

public class FractionOperator implements NumberOperator<Fraction> {
	
	public Fraction add(Fraction first, Fraction second) {
		return (Fraction) ((Fraction) first).add((Fraction) second);
	}
	
	public Fraction subtract(Fraction first, Fraction second) {
		return (Fraction) ((Fraction) first).subtract((Fraction) second);
	}
	
	public Fraction multiply(Fraction first, Fraction second) {
		return (Fraction) ((Fraction) first).multiply((Fraction) second);
	}
	
	public Fraction divide(Fraction first, Fraction second) {
		return (Fraction) ((Fraction) first).divide((Fraction) second);
	}

	@Override
	public Fraction cast(Number i) {
		
		if (i instanceof Integer) {
			return new Fraction((Integer) i);
		} else if (i instanceof Double) {
			return new Fraction((Double) i);
		} else if (i instanceof Fraction) {
			return (Fraction) i;
		} else {
			throw new IllegalArgumentException(String.format("%s is an unsupported number type", i.getClass()));
		}
	}
	
	


}
