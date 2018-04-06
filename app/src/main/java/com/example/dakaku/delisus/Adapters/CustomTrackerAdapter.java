package com.example.dakaku.delisus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;

import java.util.List;

/**
 * Created by dakaku on 6/4/18.
 */

public class CustomTrackerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "CustomTrackerAdapter";

    List<Recipe> recipeList;
    Context context;

    public CustomTrackerAdapter(List<Recipe> recipeList, Context context) {
        this.recipeList = recipeList;
        this.context = context;
        Log.v(TAG, "Constructor called");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false);
        Log.v(TAG, "OnCreateView called");
        return new NewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String letter = String.valueOf(recipeList.get(position).getLabel().charAt(0));

        ((NewHolder) holder).tvFirstLetter.setText(letter);
        ((NewHolder) holder).tvCalorie.setText(String.valueOf(recipeList.get(position).getCalories()));
        ((NewHolder) holder).tvLabel.setText(recipeList.get(position).getLabel());
        Log.v(TAG, "OnBindView called");
    }

    @Override
    public int getItemCount() {
        Log.v(TAG, "Size is" + recipeList.size());
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

            Log.v(TAG, "HolderConstructor called");

        }
    }


}
