package com.cogpunk.math;

public interface NumberOperator<P extends Number> {
	
	P add(P first, P second);
	
	P subtract(P first, P second);
	
	P multiply(P first, P second) ;
	
	P divide(P first, P second);
	
	P cast(Number i);
	
	int hashCode();
	
	/**
	 * @param obj The object to compare with
	 * @return There this is an equivalent NumberOperator
	 */
    boolean equals(Object obj);
	
}
