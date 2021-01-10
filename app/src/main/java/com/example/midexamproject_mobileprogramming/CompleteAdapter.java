package com.example.midexamproject_mobileprogramming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.midexamproject_mobileprogramming.MenuList;
import com.example.midexamproject_mobileprogramming.R;

import java.util.ArrayList;

/*
    Marissa Leviani
    2201835321
*/


public class CompleteAdapter extends BaseAdapter {

    ArrayList<OrderList> lists;
    Context con;

    public CompleteAdapter(ArrayList<OrderList> lists, Context con) {
        this.lists = lists;
        this.con = con;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(con).inflate(R.layout.complete_list, parent, false);
        }
        OrderList orderList = (OrderList) getItem(position);
        TextView name = convertView.findViewById(R.id.menuItemName);
        TextView price = convertView.findViewById(R.id.menuItemPrice);
        TextView qty = convertView.findViewById(R.id.menuItemQty);

        name.setText(orderList.getNameOrder());
        price.setText(orderList.getPriceOrder());
        qty.setText(orderList.getNumOrder());

        return convertView;
    }
}
