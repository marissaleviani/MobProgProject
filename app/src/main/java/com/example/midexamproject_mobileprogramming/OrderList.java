package com.example.midexamproject_mobileprogramming;

/*
    Marissa Leviani
    2201835321
*/
public class OrderList {

    private String nameOrder;
    private String priceOrder, numOrder;

    public OrderList(){

    }

    public OrderList(String nameOrder, String priceOrder, String numOrder) {
        this.nameOrder = nameOrder;
        this.priceOrder = priceOrder;
        this.numOrder = numOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public String getPriceOrder() {
        return priceOrder;
    }

    public String getNumOrder() {
        return numOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public void setPriceOrder(String priceOrder) {
        this.priceOrder = priceOrder;
    }

    public void setNumOrder(String numOrder) {
        this.numOrder = numOrder;
    }
}
