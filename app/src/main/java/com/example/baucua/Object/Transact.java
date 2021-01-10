package com.example.baucua.Object;

public class Transact {
    private float amount;
    private String datetime;
    private String transaction_type;

    public Transact(float amount, String datetime, String transaction_type) {
        this.amount = amount;
        this.datetime = datetime;
        this.transaction_type = transaction_type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
}
