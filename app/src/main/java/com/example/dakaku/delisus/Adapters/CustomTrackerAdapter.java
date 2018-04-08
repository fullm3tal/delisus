package com.example.dakaku.delisus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.Listeners.MealClickListener;
import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.ui.RecipeData;

import java.util.List;

/**
 * Created by dakaku on 6/4/18.
 */

public class CustomTrackerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "CustomTrackerAdapter";

    List<RecipeData> recipeList;
    Context context;

    public CustomTrackerAdapter(List<RecipeData> recipeList, Context context) {
        this.recipeList = recipeList;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false);
        return new NewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        RecipeData recipeData=recipeList.get(position);
        Recipe recipe=recipeData.getRecipe();

        String letter = String.valueOf(recipe.getLabel().charAt(0));
        ((NewHolder) holder).tvFirstLetter.setText(letter);
        ((NewHolder) holder).tvCalorie.setText(String.valueOf(recipe.getCalories()));
        ((NewHolder) holder).tvLabel.setText(recipe.getLabel());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder {
        public TextView tvFirstLetter;
        public TextView tvCalorie;
        public TextView tvLabel;

        public NewHolder(View itemView) {
            super(itemView);
            tvFirstLetter = itemView.findViewById(R.id.tv_recipeFirstLetter);
            tvCalorie = itemView.findViewById(R.id.tv_recipeCalorie);
            tvLabel = itemView.findViewById(R.id.tv_recipeLabel);

        }
    }
}
