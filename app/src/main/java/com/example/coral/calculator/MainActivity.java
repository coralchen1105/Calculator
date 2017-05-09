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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TextExpression = "";

    private TextView displayStringExpression;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayStringExpression = (TextView)findViewById(R.id.displayNumber);
        displayStringExpression.setText("0");
    }

    public void iniNumber(View v){

        Button b = (Button) v;
        TextExpression += b.getText().toString();
        displayStringExpression.setText(TextExpression);
    }

    public void clearAll(View v){
        result = 0;
        displayStringExpression.setText(Double.toString(result));
        TextExpression = "";
    }

    public void tokenizerAction(View v) throws ParseException{
        Subs subs = new Subs();
        Tokenizer tz = new MySimpleTokenizer(TextExpression);
        Expression pe = Expression.parseExp(tz);
        result = pe.evaluate(subs);
        displayStringExpression.setText(Double.toString(result));
    }

    public void replay(View v) throws IOException {

    }

}
