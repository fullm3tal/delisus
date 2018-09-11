package com.example.dakaku.delisus.network;

import com.example.dakaku.delisus.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dakaku on 12/3/18.
 */

public class RestClient {

    private static Retrofit retrofitInstance = null;

    private RestClient(){

    }

    public static RetrofitApi getInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance.create(RetrofitApi.class);
    }

}
