package com.abhishek_tax;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText salary, tax;
    Button com;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salary= findViewById(R.id.salary);
        tax= findViewById(R.id.tax);

        com= findViewById(R.id.com);

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int income, etax;

                income = Integer.parseInt(salary.getText().toString()) *12;

                if (income>1 && income<200000){
                    etax = income * 15/100;
                    tax.setText(Integer.toString(etax));
                }
                else if (income>200000 && income <350000) {
                    etax = (200000 * 1/100) +(income-200000)*15/100;
                    tax.setText(Integer.toString(etax));
                }
                else if (income>350000) {
                    etax = 200000 * 1/100 +150000*15/100+ (income - 350000)*25/100;
                    tax.setText(Integer.toString(etax));
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(com.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}
