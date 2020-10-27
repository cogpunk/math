package com.cogpunk.math;

public class IntegerOperator implements NumberOperator<Integer> {
	
	@Override
	public Integer add(Integer first, Integer second) {
		return first + second;
	}
	
	@Override
	public Integer subtract(Integer first, Integer second) {
		return first - second;
	}
	
	@Override
	public Integer multiply(Integer first, Integer second) {
		return first * second;
	}
	
	@Override
	public Integer divide(Integer first, Integer second) {
		return first / second;
	}

	@Override
	public Integer cast(Number i) {
		return i.intValue();
	}
	
	
	
}
