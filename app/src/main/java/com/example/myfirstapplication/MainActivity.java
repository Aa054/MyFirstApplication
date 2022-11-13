package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    TextView textResult;
    double num = 0;
    double saveNum = 0;
    String massage = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        textResult = (TextView) findViewById(R.id.textResult);
    }


    public void onClick(View v) {
        Button btn = (Button) v;
        if(v.getId()==R.id.buttonPlus){
            massage += "+";
            textResult.setText(massage);
            saveNum = num;
            num = 0;
            operator = "+";
        }

         else if(v.getId()==R.id.buttonMinis){
            massage += "-";
            textResult.setText(massage);
            saveNum = num;
            num = 0;
            operator = "-";
        }

        else if(v.getId()==R.id.buttonMul){
            massage += "*";
            textResult.setText(massage);
            saveNum = num;
            num = 0;
            operator = "*";
        }

        else if(v.getId()==R.id.buttonDiv){
            massage += "/";
            textResult.setText(massage);
            saveNum = num;
            num = 0;
            operator = "/";
        }

        else if(v.getId()==R.id.buttonCleer){
            massage += "";
            textResult.setText(massage);
            saveNum = 0;
            num = 0;
        }

        else{
            num =(num * 10) + Double.parseDouble(btn.getText().toString());
            massage += btn.getText().toString();
            textResult.setText(massage);
        }
    }

    public void resultOnClick(View v) {
        double total = 0;
        if(operator.equals("+")){
            total = saveNum + num;
        }

        if(operator.equals("-")){
            total = saveNum - num;
        }

        if(operator.equals("/")){
            total = saveNum / num;
        }

        if(operator.equals("*")){
            total = saveNum * num;
        }

        if((total*10) % 10 == 0) {
            textResult.setText(massage + "=" + (int) total);
        } else{
            DecimalFormat decimalFormat = new DecimalFormat("0.0000");
            textResult.setText(massage + "=" +decimalFormat.format(total)+"...");

        }

        textResult.setText(massage + "=" + total);
        num = 0;
        saveNum = 0;
        massage = "";
    }
}
