package com.example.coral.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.databinding.DataBindingUtil;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Button> numberList = new ArrayList<Button>();

    private double valueOne = Double.NaN;
    private double valueTwo;
    private String valueOneText;
    private String valueTwoText;
    private String operator = "";
    private TextView displayNumber;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button ze;
    private TextView numberDisplay;
    private Button plus;
    private Button minus;
    private Button divide;
    private Button mult;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.one);numberList.add(one);
        two = one = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        ze = (Button) findViewById(R.id.ze);
        plus = (Button) findViewById(R.id.plus);




    }

    public void iniNumber(View v){
        Button b = (Button) v;

        double buttonNumber = Integer.parseInt(b.getText().toString());

        if(operator == ""){
            valueOneText += b.getText().toString();

        }else{
            valueTwoText += b.getText().toString();
        }
    }

    public void iniOperator(View v){
        Button b = (Button) v;
        operator = b.getText().toString();

    }

    public void mathOperate(View v) {

        valueOne = Double.parseDouble(valueOneText);
        valueTwo = Double.parseDouble(valueTwoText);
        
        switch (operator){
            case "+": Maths.add(valueOne,valueTwo);
            case "-": Maths.sub(valueOne,valueTwo);
            case "*": Maths.mult(valueOne,valueTwo);
            case "/": Maths.div(valueOne,valueTwo);
        }
    }



}
