package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/*
    Marissa Leviani
    2201835321
*/

public class Cart extends AppCompatActivity {


    ArrayList<MenuList> lists = ListData.getInstance().list;
    Button payBtn;
    ListView listView;
    TextView totPrice;
    String menuName, totalPrice, qtyValue, priceValue;
    LinearLayout linearLayout;
    CartAdapter cartAdapter;
    Intent intent;
    int menuqty, menuprice;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        totPrice = findViewById(R.id.totPrice);
        listView = findViewById(R.id.listView);
        payBtn = findViewById(R.id.paybtn);
        linearLayout = findViewById(R.id.linearLayout);
        backBtn = findViewById(R.id.backtoHome);

        if(getIntent().getExtras() != null){
            intent = getIntent();
            menuName = intent.getStringExtra(Detail.Name);

            qtyValue = intent.getStringExtra("QtyVal");
            menuqty = Integer.parseInt(qtyValue);

            priceValue = intent.getStringExtra("PriceVal");
            menuprice = Integer.parseInt(priceValue);

            lists.add(new MenuList(menuName,menuprice,menuqty));
            totPrice.setText(Total());
            cartAdapter = new CartAdapter(lists, this);
            listView.setAdapter(cartAdapter);
        }else{
            if(lists.isEmpty()){
                linearLayout.setVisibility(View.GONE);
                Toast ts = Toast.makeText(getApplicationContext(), "No Data!", Toast.LENGTH_SHORT);
                ts.show();
            }else{
                linearLayout.setVisibility(View.VISIBLE);
                cartAdapter = new CartAdapter(lists, this);
                listView.setAdapter(cartAdapter);
            }
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Cart.this, MainActivity.class);
                startActivity(intent3);
            }
        });

    }

    private String Total() {
        int subtotal=0;
        for(MenuList list: lists){
            subtotal += (list.getPrice()*list.getNum());
        }
        totalPrice = String.valueOf(subtotal);
        return totalPrice;
    }


    public void OpenNextPage(View view) {
        intent = new Intent(this, Complete.class);
        String totalPrice = totPrice.getText().toString();
        intent.putExtra("TotalPrice", totalPrice);
        intent.putExtra("Quantity", qtyValue);
        intent.putExtra("MenuName", menuName);
        intent.putExtra("MenuPrice", priceValue);
        startActivity(intent);
        finish();
    }


}
