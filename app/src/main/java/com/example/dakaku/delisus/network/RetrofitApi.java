package com.example.dakaku.delisus.network;

import com.example.dakaku.delisus.pojo.FoodData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dakaku on 12/3/18.
 */

public interface RetrofitApi {

    @GET("/search")
    public Call<FoodData> getRecipes(@Query("q") String data
            , @Query("app_id") String id
            , @Query("app_key")String key
            , @Query("from") int start
            , @Query("to") int end
    );


//    @GET("/search?q=chicken&app_id=6dc7d75c&app_key=7f43d81b96e094af647a9fe5156f0d59&from=0&to=10")
//    public Call<List<Recipe>> getRecipes();

}
