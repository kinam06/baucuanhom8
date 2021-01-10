package com.example.baucua;

import com.example.baucua.Object.DW;
import com.example.baucua.Object.Ez;
import com.example.baucua.Object.Transact;
import com.example.baucua.Object.User;
import com.example.baucua.Object.UserName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("register")
    Call<User> reg(@Body User user);

    @POST("login")
    Call<User> login(@Body User user);

    @POST("withdraw")
    Call<User> Withdraw(@Body DW dw);

    @POST("deposit")
    Call<User> Deposit(@Body DW dw);

    @POST("getAllUsers")
    Call<ArrayList<User>> getAllUsers(@Body Ez ez);

    @POST("getHistoryTransactOfUser")
    Call<ArrayList<Transact>> getTransaction(@Body UserName userName);
}
