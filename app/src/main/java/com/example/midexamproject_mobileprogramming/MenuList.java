package com.example.midexamproject_mobileprogramming;

/*
    Marissa Leviani
    2201835321
*/

public class MenuList {

    private String name;
    private Integer price, num;

    public MenuList(){

    }

    public MenuList(String name, Integer price, Integer num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }


    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}