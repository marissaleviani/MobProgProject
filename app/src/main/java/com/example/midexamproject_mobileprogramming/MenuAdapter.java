package com.example.midexamproject_mobileprogramming;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
    Marissa Leviani
    2201835321
*/


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    String menu[], price[];
    int img[];
    Context c;

    public MenuAdapter(Context c, String menu[], String price[], int img[]){
        this.c = c;
        this.menu = menu;
        this.price = price;
        this.img = img;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.menu_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, final int position) {
        holder.namaItem.setText(menu[position]);
        holder.itemPrice.setText(price[position]);
        holder.imgItem.setImageResource(img[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, Detail.class);
                intent.putExtra("menu", menu[position]);
                intent.putExtra("price", price[position]);
                intent.putExtra("img", img[position]);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView namaItem, itemPrice;
        ImageView imgItem;
        LinearLayout linearLayout;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            namaItem = itemView.findViewById(R.id.namaItem);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            imgItem = itemView.findViewById(R.id.imgItem);
            linearLayout = itemView.findViewById(R.id.menu_row);
        }
    }


}
