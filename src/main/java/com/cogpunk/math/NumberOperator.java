package com.cogpunk.math;

public interface NumberOperator<P extends Number> {
	
	public P add(P first, P second);
	
	public P subtract(P first, P second);
	
	public P multiply(P first, P second) ;
	
	public P divide(P first, P second);
	
	public P cast(Number i);
	
	public int hashCode();
	
	/**
	 * @param obj The object to compare with
	 * @return There this is an equivalent NumberOperator
	 */
	public boolean equals(Object obj);
	
}
