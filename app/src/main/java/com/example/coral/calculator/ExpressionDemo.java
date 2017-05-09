package com.example.coral.calculator;

import java.text.ParseException;

public class ExpressionDemo {

	static String exp1 = "2 * 5 + 3";
	static String exp2 = "(2 * 44) + 2";
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Subs subs = new Subs();
		Tokenizer tz = new MySimpleTokenizer(exp2);
		Expression pe = Expression.parseExp(tz);
		System.out.println(pe.show() + "=" + pe.evaluate(subs));

		
		// check each character in tz
/*		while(tz.hasNext()){
			System.out.println(" " + tz.current() + tz.current().getClass());
			// move to next character and check
			tz.next();
		}*/
	
	}

}
