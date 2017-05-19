package com.example.coral.calculator;

public class MySimpleTokenizer extends Tokenizer {

	private String text;
	private int pos;
	private Object current;
	
	static final char whitespace[] = { ' ', '\n', '\t' };
	static final char symbol[] = { '(', ')', '=', ':', '?', ',', '*', '+' ,'-', '/'};
	
	
	public MySimpleTokenizer(String text) {
		this.text = text;
		this.pos = 0;
		next();
	}
	
	boolean hasNext() {
		return current != null;
	}
	
	Object current() {
		return current;
	}
	
	
	public void next() {
		consumewhite();
		// check if the text finish 
		if (pos == text.length()) {
			current = null;
		}
		
		// if the position of the text is within symbol, then current == the char
		else if (isin(text.charAt(pos), symbol)) {
			current = "" + text.charAt(pos);
			pos++;
			
		} 
		// check if the character is digit
		else if (Character.isDigit(text.charAt(pos))) {
			int start = pos;
			while (pos < text.length() && Character.isDigit(text.charAt(pos)) )
				pos++;
			if (pos+1 < text.length() && text.charAt(pos) == '.' &&
					Character.isDigit(text.charAt(pos+1))) {
				pos++;
				while (pos < text.length() && Character.isDigit(text.charAt(pos)))
					pos++;
				current = Double.parseDouble(text.substring(start, pos));
			} else {
			    current = Integer.parseInt(text.substring(start, pos));
			}
		} else {
			int start = pos;
			while (pos < text.length() && !isin(text.charAt(pos), symbol)
					&& !isin(text.charAt(pos), whitespace))
				pos++;
			current = text.substring(start, pos);
		}
	}
	
	private void consumewhite() {
		
		// check the position is whitespace, if yes then move position 
		while (pos < text.length() && isin(text.charAt(pos), whitespace))
			pos++;
	}
	
	private boolean isin(char c, char charlist[]) {
		for (char w : charlist) {
			if (w == c)
				return true;
		}
		return false;
	}

}
