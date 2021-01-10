package com.example.midexamproject_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/*
    Marissa Leviani
    2201835321
*/


public class Menu extends AppCompatActivity {

    public static final String EXTRA_ITEM = "com.example.midexamproject_mobileprogramming.EXTRA_ITEM";


    RecyclerView recyclerView;
    TextView menu;

    String drinkList[],snackList[], foodList[], menuName[];
    String drinkPrice[], snackPrice[], foodPrice[], price[];
    int drinkImgList[] = {R.drawable.air_mineral, R.drawable.jus_apel, R.drawable.jus_mangga, R.drawable.jus_alpukat};
    int snackImgList[] = {R.drawable.macaroon, R.drawable.french_fries, R.drawable.cake, R.drawable.nachos};
    int foodImgList[] = {R.drawable.fried_rice, R.drawable.fried_chicken, R.drawable.ramen_soup, R.drawable.gado_gado};
    int img[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent intent = getIntent();
        String menuItem = intent.getStringExtra(MainActivity.EXTRA_MENUITEM);

        menu = findViewById(R.id.namamenu);
        recyclerView = findViewById(R.id.recyclerView);


        drinkList = getResources().getStringArray(R.array.drinksItem);
        foodList = getResources().getStringArray(R.array.foodsItem);
        snackList = getResources().getStringArray(R.array.snacksItem);

        drinkPrice = getResources().getStringArray(R.array.drinksPrice);
        snackPrice = getResources().getStringArray(R.array.snacksPrice);
        foodPrice = getResources().getStringArray(R.array.foodsPrice);

        if (menuItem.equals("Drinks")) {
            menuName = drinkList;
            price = drinkPrice;
            img = drinkImgList;
        }else if (menuItem.equals("Foods")) {
            menuName = foodList;
            price = foodPrice;
            img = foodImgList;
        } else if (menuItem.equals("Snacks")) {
            menuName = snackList;
            price = snackPrice;
            img = snackImgList;
        }

        MenuAdapter menuAdapter = new MenuAdapter(this, menuName, price, img);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openCartPage(View view) {
        Intent intent = new Intent(Menu.this, Cart.class);
        startActivity(intent);
    }

}
