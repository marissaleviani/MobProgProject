package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/*

    Marissa Leviani
    2201835321
    Mobile Programming Mid Exam Project

 */

public class MainActivity extends AppCompatActivity {

    CardView drinksMenu, snacksMenu, foodsMenu,topUpMenu;
    ImageView myOrder;
    Button myOrderBtn;
    LinearLayout mapLoc;
    public static final String EXTRA_MENUITEM = "com.example.midexamproject_mobileprogramming.EXTRA_MENUITEM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drinksMenu = findViewById(R.id.drinksMenu);
        snacksMenu = findViewById(R.id.snacksMenu);
        foodsMenu = findViewById(R.id.foodsMenu);
        topUpMenu = findViewById(R.id.topUpMenu);
        myOrderBtn = findViewById(R.id.myOrderBtn);
        mapLoc = findViewById(R.id.mapLoc);

        drinksMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String menuItem = "Drinks";
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra(EXTRA_MENUITEM, menuItem);
                startActivity(intent);
            }
        });

        snacksMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String menuItem = "Snacks";
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra(EXTRA_MENUITEM, menuItem);
                startActivity(intent);
            }
        });

        foodsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String menuItem = "Foods";
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra(EXTRA_MENUITEM, menuItem);
                startActivity(intent);
            }
        });

        topUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Topup.class);
                startActivity(intent);
            }
        });

        mapLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map.class);
                startActivity(intent);
            }
        });

    }

    public void openOrderPage(View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }
}
