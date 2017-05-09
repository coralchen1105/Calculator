package com.example.coral.calculator;

public class ExpressionOperator extends Expression {
	
	Expression left, right;
	public ExpressionOperator(Expression l, Expression r){
		left = l;
		right = r;
	} 
	@Override
	public String show() {
		return null;
	}

	@Override
	public int evaluate(Subs subs) {
		return 0;
	}

	@Override
	public int size() {
		return 1 + left.size() + right.size();
	}

	@Override
	public int height() {
		return 1 + Math.max(left.height(), right.height());
	}

	@Override
	public int countOperator() {
		return 1 + left.countOperator() + right.countOperator(); 
	}

}
