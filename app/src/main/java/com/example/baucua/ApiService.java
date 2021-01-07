package com.example.baucua;

import com.example.baucua.Object.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("register")
    Call<User> reg(@Body User user);

    @POST("login")
    Call<User> login(@Body User user);

    @GET("getAllUsers")
    Call<List<User>> getAllUsers(@Body User user);

}
