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

    private double valueOne;
    private double valueTwo;
    private String valueOneText = "";
    private String valueTwoText = "";
    private String operator = "";
    private TextView displayNumber;
    private double result;
    private TextView displayOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNumber = (TextView)findViewById(R.id.displayNumber);
        displayNumber.setText("0");
        displayOperator = (TextView)findViewById(R.id.operator);
    }

    public void iniNumber(View v){
        Button b = (Button) v;

        if(operator == ""){
            valueOneText += b.getText().toString();
            displayNumber.setText(valueOneText);

        }else{
            valueTwoText += b.getText().toString();
            displayNumber.setText(valueTwoText);
        }
    }

    public void iniOperator(View v){
        Button b = (Button) v;

        if(operator!=null){
            valueOne = result;
        }
        operator = b.getText().toString();

    }

    public void mathOperate(View v) {

        if(valueOne==0){
            valueOne = Double.parseDouble(valueOneText);
        }
        valueTwo = Double.parseDouble(valueTwoText);
        displayOperator.setText(operator);

        switch (operator){
            case "+": result = Maths.add(valueOne,valueTwo);
                break;
            case "-": result = Maths.sub(valueOne,valueTwo);
                break;
            case "*": result = Maths.mult(valueOne,valueTwo);
                break;
            case "/": result = Maths.div(valueOne,valueTwo);
                break;
        }

        displayNumber.setText(Double.toString(result));
        valueOne = result;
        valueTwoText = "";
    }

    public void clearAll(View v){
        valueOne = 0f;
        valueTwo = 0f;
        valueOneText = "";
        valueTwoText = "";
        operator = "";
        displayNumber.setText("0");
        result = 0;
    }



}
