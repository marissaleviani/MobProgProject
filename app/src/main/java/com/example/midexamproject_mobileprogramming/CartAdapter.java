package com.example.midexamproject_mobileprogramming;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
    Marissa Leviani
    2201835321
*/


public class CartAdapter extends BaseAdapter {

    ArrayList<MenuList>lists;
    Context cn;

    public CartAdapter(ArrayList<MenuList> lists, Context cn) {
        this.lists = lists;
        this.cn = cn;
    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(cn).inflate(R.layout.list_row, parent, false);
        }

        MenuList menuList = (MenuList)getItem(position);
        TextView nameList = convertView.findViewById(R.id.nameList);
        TextView priceList = convertView.findViewById(R.id.priceList);
        TextView qtyList = convertView.findViewById(R.id.qtyList);
        Button deleteRow = convertView.findViewById(R.id.cancelBtn);

        nameList.setText(menuList.getName());
        priceList.setText(String.valueOf(menuList.getPrice()));
        qtyList.setText(String.valueOf(menuList.getNum()));

        deleteRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuList deleteMenu = lists.get(position);
                lists.remove(deleteMenu);
                Intent intent = new Intent(cn, Cart.class);
                cn.startActivity(intent);
            }
        });

        return convertView;
    }
}
