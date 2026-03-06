package dev.hazoe.exercise.api.dto;


public class FilteredProduct {

    private String barCode;

    public FilteredProduct(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}