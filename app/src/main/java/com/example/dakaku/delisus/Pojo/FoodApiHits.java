package com.example.dakaku.delisus.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 19/3/18.
 */

public class FoodApiHits {

        @SerializedName("recipe")
        @Expose
        private Recipe recipe;
        @SerializedName("bookmarked")
        @Expose
        private Boolean bookmarked;
        @SerializedName("bought")
        @Expose
        private Boolean bought;

    public Recipe getRecipe() {
        return recipe;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public Boolean getBought() {
        return bought;
    }
}


