package dev.hazoe.exercise.api.dto;


public class SortedProduct {

    private String barCode;
    private int price;

    public SortedProduct(String barCode, int price) {
        this.barCode = barCode;
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public int getPrice() {
        return price;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}