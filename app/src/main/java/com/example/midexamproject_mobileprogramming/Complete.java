package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/*
    Marissa Leviani
    2201835321
*/


public class Complete extends AppCompatActivity {

    ArrayList<OrderList>list;
    Button doneBtn;
    TextView totalPrice;
    String menuName,total;
    String price,qty ;
    ListView listView2;
    CompleteAdapter completeAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        intent = getIntent();
        totalPrice = findViewById(R.id.subtotalPrice);
        listView2 = findViewById(R.id.completeOrderList);
        total = intent.getStringExtra("TotalPrice");
        totalPrice.setText(total);
        menuName = intent.getStringExtra("MenuName");
        price = intent.getStringExtra("MenuPrice");
        qty = intent.getStringExtra("Quantity");


//        list.add(new OrderList(menuName, price, qty));
//        completeAdapter = new CompleteAdapter(list, this);
//        listView2.setAdapter(completeAdapter);

    }

    public void Done(View view) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
