package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DebitCard extends AppCompatActivity {

    EditText cardNum, dailyLim;
    Button doneBtn;
    ImageView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);

        cardNum = findViewById(R.id.nomorKartu);
        dailyLim = findViewById(R.id.limitHarian);
        doneBtn = findViewById(R.id.doneFormBtn);
        cancel = findViewById(R.id.cancel);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNumInput = cardNum.getText().toString();
                String dailyLimInput = dailyLim.getText().toString();

                if(cardNumInput.isEmpty()){
                    cardNum.setError("Field can't be empty");
                }else if(dailyLimInput.isEmpty()){
                    dailyLim.setError("Field can't be empty");
                }else{
                    Intent intent = new Intent(DebitCard.this, Topup.class);
                    startActivity(intent);
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DebitCard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
