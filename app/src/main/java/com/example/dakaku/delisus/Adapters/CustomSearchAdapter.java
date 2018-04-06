package com.example.dakaku.delisus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.Listeners.RVItemClick;
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
    public RVItemClick rvItemClick;

    public CustomSearchAdapter(List<FoodApiHits> foodApiHitsList, Context context, RVItemClick mRVItemClick) {
        this.foodApiHitsList = foodApiHitsList;
        this.context = context;
         rvItemClick=mRVItemClick;
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
        String firstLetter=String.valueOf(recipe.getLabel().charAt(0));
        ((MyHolder)holder).textViewLabel.setText(recipe.getLabel());
        ((MyHolder)holder).textViewFirstLetter.setText(firstLetter);
        ((MyHolder)holder).textViewCalorie.setText(recipe.getCalories().toString());
    }

    @Override
    public int getItemCount() {
        return foodApiHitsList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textViewLabel;
        public TextView textViewFirstLetter;
        public TextView textViewCalorie;

        public MyHolder(View itemView) {
            super(itemView);
            textViewLabel=itemView.findViewById(R.id.tv_recipeLabel);
            textViewFirstLetter=itemView.findViewById(R.id.tv_recipeFirstLetter);
            textViewCalorie=itemView.findViewById(R.id.tv_recipeCalorie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition=getAdapterPosition();
            Recipe mRecipe= foodApiHitsList.get(adapterPosition).getRecipe();
            rvItemClick.onRecyclerItemClick(mRecipe);
        }
    }
}
