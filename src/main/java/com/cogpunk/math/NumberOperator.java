package com.cogpunk.math;

public interface NumberOperator<P extends Number> {
	
	public P add(P first, P second);
	
	public P subtract(P first, P second);
	
	public P multiply(P first, P second) ;
	
	public P divide(P first, P second);
	
	public P cast(Number i);
	
}
