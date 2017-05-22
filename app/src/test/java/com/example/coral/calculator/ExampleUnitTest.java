package com.example.coral.calculator;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSimpleTok(){
        Tokenizer tz = new MySimpleTokenizer("2 * 5 + 3");
        assertEquals(new Integer(2), tz.current());
        tz.next();
        assertEquals("*", tz.current());
    }

    @Test
    public void testExpression() throws ParseException {
        Tokenizer tz = new MySimpleTokenizer("2 * 5 + 3");
        Expression pe = Expression.parseExp(tz);
        assertEquals("(( 2 *  5) +  3)", pe.show());
    }

    @Test
    public void testEvaluation() throws ParseException {
        Subs subs = new Subs();
        Tokenizer tz = new MySimpleTokenizer("2 * 5 + 3");
        Expression pe = Expression.parseExp(tz);
        assertEquals(13, pe.evaluate(subs));
    }

}