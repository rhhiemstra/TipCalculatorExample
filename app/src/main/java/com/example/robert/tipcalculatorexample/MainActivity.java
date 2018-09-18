package com.example.robert.tipcalculatorexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText billAmountEt;
    private TextView tipPerEt;
    private TextView tipEt;
    private TextView totalEt;
    String billAmountTxt;
    float tipPercent=0.15f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEt = (EditText) findViewById(R.id.billAmountEt);
        tipPerEt = (TextView) findViewById(R.id.percentEv);
        tipEt = (TextView) findViewById(R.id.percentEv2);
        totalEt = (TextView) findViewById(R.id.totalEt);

        final Button plusBtn = (Button) findViewById(R.id.plus);
        final Button minusBtn = (Button) findViewById(R.id.minus);
        final Button enterBtn = (Button) findViewById(R.id.enterBtn);
        NumberFormat nf = NumberFormat.getPercentInstance();
        tipPerEt.setText(nf.format(tipPercent));


        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calulateAndDisplay();
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercent += 0.01f;
                NumberFormat nf = NumberFormat.getPercentInstance();
                tipPerEt.setText(nf.format(tipPercent));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercent -= 0.01f;
                NumberFormat nf = NumberFormat.getPercentInstance();
                tipPerEt.setText(nf.format(tipPercent));

            }
        });

    }

    public void calulateAndDisplay(){
        billAmountTxt = billAmountEt.getText().toString();
        float billAmount;
        if(billAmountTxt.equals(""))
            billAmount = 0;
        else billAmount = Float.parseFloat(billAmountTxt);
        float tipAmount = billAmount * tipPercent;

        NumberFormat c = NumberFormat.getCurrencyInstance();
        tipEt.setText(c.format(tipAmount));

        float total = billAmount + tipAmount;
        totalEt.setText(c.format(total));


    }
}
