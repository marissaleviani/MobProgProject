package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Topup extends AppCompatActivity {


    private static final String EXTRA_BALANCE = "com.example.midexamproject_mobileprogramming.EXTRA_BALANCE";
    private LinearLayout debitCard;
    private TextView balanceTxt;
    private EditText amountTxt;
    private Button proceedBtn;
    int sum;
    String saldo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        debitCard = findViewById(R.id.addDebitCard);
        balanceTxt = findViewById(R.id.saldoTxt);
        amountTxt = findViewById(R.id.amountTopUp);
        proceedBtn = findViewById(R.id.submitAmount);

        balanceTxt.setText("230000");

        debitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Topup.this, DebitCard.class);
                startActivity(intent);
            }
        });

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amo = amountTxt.getText().toString();
                if(amo.isEmpty()){
                    amountTxt.setError("Field can't be empty!");
                }else {
                    int num = Integer.parseInt(amountTxt.getText().toString());
                    int num2 = Integer.parseInt(balanceTxt.getText().toString());
                    sum = num + num2;
                    saldo = String.valueOf(sum);
                    balanceTxt.setText(saldo);
                    Toast.makeText(Topup.this, "Top Up Succes!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Topup.this, MainActivity.class);
                    intent.putExtra(EXTRA_BALANCE, saldo);
                    startActivity(intent);
                }
            }
        });


    }
}
