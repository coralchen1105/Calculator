package com.example.coral.calculator;

/**
 * Created by coral on 18/03/2017.
 */

public class Maths {

    public static double add(double a, double b){
        double result = a+b;
        return result;

    }

    public static double sub(double a, double b){
        double result = a-b;
        return result;

    }

    public static double mult(double a, double b){
        double result = a*b;
        return result;

    }

    public static double div(double a, double b){
        double result;
        if(b!=0){
           result = a/b;
            return result;
        }else{
            return 0;
        }

    }

}
