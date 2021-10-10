package com.example.easy_emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText amountInput;
    EditText interestInput;
    EditText yearInput;
    Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountInput = (EditText) findViewById(R.id.amount);
        interestInput = (EditText) findViewById(R.id.interest);
        yearInput = (EditText) findViewById(R.id.years);

        calculateButton = (Button) findViewById(R.id.calculateButton);
    }
    //Method Used by button on click
    public void calculate(View v)
    {
        //Getting text from input fields and converting to double values
        double amount=Double.valueOf(amountInput.getText().toString());
        double interest=Double.valueOf(interestInput.getText().toString());
        double years=Double.valueOf(yearInput.getText().toString());
        //Calculating monthly interest rate
        double r=(interest/12)/100;
        //Calculating # of months
        double n=years*12;
        //Calculating EMI
        double EMI = amount*r*((Math.pow((1+r),n))/(Math.pow((1+r),n)-1));
        //Rounding to 2 decimals places
        EMI=Math.round(EMI*100.0)/100.0;

        //Displaying the result
        TextView answerText=(TextView) findViewById(R.id.answer);
        answerText.setText("Monthly Payment: $"+String.valueOf(EMI));

    }
}