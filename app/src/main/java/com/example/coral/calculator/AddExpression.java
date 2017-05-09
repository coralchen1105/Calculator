package com.example.coral.calculator;

public class AddExpression extends ExpressionOperator {
	
	public AddExpression(Expression l, Expression r){
	super(l,r);
	} 
	@Override
	public String show() {
		return "(" + left.show() + " + " + right.show() + ")" ; 
	}
	@Override
	public int evaluate(Subs subs) {
		return left.evaluate(subs) + right.evaluate(subs);
		
	}
	
}
