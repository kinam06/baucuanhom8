package com.example.baucua;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://25.22.115.26:12481/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static ApiService getApiService(){
        ApiService apiService = getRetrofit().create(ApiService.class);
        return apiService;
    }
}