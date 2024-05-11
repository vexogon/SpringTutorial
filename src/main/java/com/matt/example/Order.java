package com.matt.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {


    @JsonProperty("c-name")
    private String customerName;


    @JsonProperty("p-name")
    private String ProductName;

    @JsonProperty("quantity")
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
