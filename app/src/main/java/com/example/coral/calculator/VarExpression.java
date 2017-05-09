package com.example.coral.calculator;

public class VarExpression extends Expression {

	String name;
	
	public VarExpression (String v){
		name = v;
	}
	
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return " " + name;
	}

	@Override
	public int evaluate(Subs subs) {
		// TODO Auto-generated method stub
		return subs.get(name);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countOperator() {
		// TODO Auto-generated method stub
		return 1; 
	}

	

}
