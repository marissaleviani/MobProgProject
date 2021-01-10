package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
    Marissa Leviani
    2201835321
*/


public class Detail extends AppCompatActivity {


    public static final String Name = "com.example.midexamproject_mobileprogramming.Name";

    TextView qty, name, item, harga;
    ImageView imageView;
    int count = 0;
    Button addCart;
    ImageView backBtn;

    String menu,price,menuName;
    int img;
    String jumlah, total;
    String num;
    ArrayList<MenuList>lists ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String itm = intent.getStringExtra(Menu.EXTRA_ITEM);

        qty = findViewById(R.id.qty);
        name = findViewById(R.id.namaItemMenu);
        item = findViewById(R.id.item);
        harga = findViewById(R.id.hargaMenuItem);
        imageView = findViewById(R.id.imageMenu);
        backBtn = findViewById(R.id.backBtn);

        getMenu();
        setMenu();
        item.setText("Beverages");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Detail.this, MainActivity.class);
                startActivity(intent1);
            }
        });

//        menuName = name.getText().toString();
//        total = harga.getText().toString();
//        jumlah = qty.getText().toString();

    }

    public void decrement(View view) {
        if(count <= 1 ){
            count = 1;
        }else {
            count--;
        }
        qty.setText("" + count);
    }

    public void increment(View view) {
        count++;
        qty.setText("" + count);
    }

    private void getMenu(){
        if (getIntent().hasExtra("img") && getIntent().hasExtra("menu") &&
        getIntent().hasExtra("price")){
            menu = getIntent().getStringExtra("menu");
            price = getIntent().getStringExtra("price");
            img = getIntent().getIntExtra("img", 1);
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setMenu(){
        name.setText(menu);
        harga.setText(price);
        imageView.setImageResource(img);

    }

    public void OpenMenuPage(View view) {
        Intent in = new Intent(Detail.this, Cart.class);
        jumlah = qty.getText().toString();
        menuName = name.getText().toString();
        total = harga.getText().toString();
        in.putExtra(Name, menuName);
        in.putExtra("QtyVal", jumlah);
        in.putExtra("PriceVal", total);
        startActivity(in);
    }

}
