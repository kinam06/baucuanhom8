package com.example.baucua.Object;

public class DW {
    private String username;
    private String amount_of_money;

    public DW(String username, String amount_of_money) {
        this.username = username;
        this.amount_of_money = amount_of_money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAmount_of_money() {
        return amount_of_money;
    }

    public void setAmount_of_money(String amount_of_money) {
        this.amount_of_money = amount_of_money;
    }
}
