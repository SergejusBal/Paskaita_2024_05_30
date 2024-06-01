package org.example;

public class Order {
    private int id;
    private String customerId;
    private double amount;
    private String status;

    public Order(int id, String customerId, double amount, String status) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}