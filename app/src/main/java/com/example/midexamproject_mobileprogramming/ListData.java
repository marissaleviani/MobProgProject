package com.example.midexamproject_mobileprogramming;

import java.util.ArrayList;

/*
    Marissa Leviani
    2201835321
*/


public class ListData {

    public ArrayList<MenuList> list;
    public static ListData instance;

    public ListData() {
        list = new ArrayList<>();
    }

    public static ListData getInstance(){
        if(instance == null){
            instance = new ListData();
        }
        return instance;
    }

}
