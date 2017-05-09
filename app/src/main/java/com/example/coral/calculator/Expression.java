package com.example.coral.calculator;

import java.text.ParseException;

public abstract class Expression {
	
	abstract public  String show();
    abstract public int evaluate(Subs subs);
    
	abstract public int size();
	abstract public int height();
	abstract public int countOperator();
	
	/*
	 * <expression> ::= <term> | <term> + <expression> | <term> - <expression>
	 * <term> ::= <factor> | <factor> * <term> | <factor> / <term>
	 * <factor> ::= <lit> | <var> | (<expression>)
	
	*/
	public static Expression parseExp(Tokenizer tz) throws ParseException{
		Expression term = parseTerm(tz);
		if(tz.currentis("+")){
			tz.next();
			Expression exp = parseExp(tz);
			return new AddExpression(term, exp);
		}else{
			return term;
		}
	}
	
	public static Expression parseTerm(Tokenizer tz) throws ParseException{
		Expression fact = parseFactor(tz);
		if(tz.currentis("*")){
			tz.next();
			Expression term = parseTerm(tz);
			return new MultExpression(fact, term);
		}else{
			return fact;
		}
	}
	
	public static Expression parseFactor(Tokenizer tz) throws ParseException{
		if(tz.current() instanceof Integer){
			Expression exp = new LitExpression((Integer)tz.current());
			tz.next();
			return exp;
		}if(tz.currentis("(")){
			tz.next();
			Expression exp = parseExp(tz);
			tz.parse(")");
			return exp;
		}
		
		else{
			Expression exp = new VarExpression((String) tz.current());
			tz.next();
			return exp;
		}
	}
	
}
