package com.example.dakaku.delisus.ui;

import com.example.dakaku.delisus.Pojo.Recipe;

/**
 * Created by dakaku on 7/4/18.
 */

public class RecipeData {

    public RecipeData() {
    }

    String childKey;
    Recipe recipe;
    String mealTitle;

    public RecipeData(String childKey, Recipe recipe, String mealTitle) {
        this.childKey = childKey;
        this.recipe = recipe;
        this.mealTitle=mealTitle;
    }

    public String getChildKey() {
        return childKey;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getMealTitle() {
        return mealTitle;
    }
}
