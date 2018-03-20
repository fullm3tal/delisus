package com.example.dakaku.delisus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.Pojo.FoodApiHits;
import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;

import java.util.List;


/**
 * Created by dakaku on 19/3/18.
 */

public class CustomSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<FoodApiHits> foodApiHitsList;
    private static final String TAG = "CustomSearchAdapter";
    Context context;

    public CustomSearchAdapter(List<FoodApiHits> foodApiHitsList, Context context) {
        this.foodApiHitsList = foodApiHitsList;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_items,parent,false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Recipe recipe=foodApiHitsList.get(position).getRecipe();
        Log.v(TAG,"TextView called");
        ((MyHolder)holder).textViewLabel.setText(recipe.getLabel());
    }

    @Override
    public int getItemCount() {
        return foodApiHitsList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        public TextView textViewLabel;

        public MyHolder(View itemView) {
            super(itemView);
            textViewLabel=itemView.findViewById(R.id.tv_recipeLabel);
        }
    }
}
