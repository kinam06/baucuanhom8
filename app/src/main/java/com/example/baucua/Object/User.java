package com.example.baucua.Object;

import com.google.gson.annotations.SerializedName;

public class User {
    private String username;
    private String password;
    private float balance;
    private String email;
    private String fullname;
    private String message;
    private String phone;
    private String user_type;

    public User(String username, String password, float balance, String email, String fullname, String phone, String user_type) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.user_type = user_type;
    }

    public User(String username, String password, String fullname, String phone, String email) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String message) {
        this.message = message;
    }

    public User(float balance, String email, String fullname, String message, String phone, String user_type) {
        this.balance = balance;
        this.email = email;
        this.fullname = fullname;
        this.message = message;
        this.phone = phone;
        this.user_type = user_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
