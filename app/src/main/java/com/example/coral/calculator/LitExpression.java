package com.example.coral.calculator;

public class LitExpression extends Expression {

	int value;
	
	public LitExpression (int v){
		value = v;
	}
	
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return " " + value;
	}

	@Override
	public int evaluate(Subs subs) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countOperator() {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
