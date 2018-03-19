package com.example.dakaku.delisus.Network;

import com.example.dakaku.delisus.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dakaku on 12/3/18.
 */

public class RetrofitClient {

    private static Retrofit retrofitInstance = null;

    private RetrofitClient(){

    }

    public static Retrofit getRetrofit() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }

}
