package com.example.company.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;


    public RetrofitService(){
        initializeRetrofit();
    }

    public void initializeRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.14:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
