package com.example.dakaku.delisus.frags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.Adapters.CustomTrackerAdapter;
import com.example.dakaku.delisus.AppConstants;
import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.SearchActivity;
import com.example.dakaku.delisus.ui.RecipeData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by dakaku on 16/2/18.
 */

public class TrackerFragment extends Fragment implements View.OnClickListener {

    Button buttonAddBreakfast;
    Button buttonAddLunch;
    Button buttonAddDinner;

    TextView textViewBreakfast;
    TextView textViewLunch;
    TextView textViewDinner;

    List<RecipeData> recipeListBreakfast;
    List<RecipeData> recipeListLunch;
    List<RecipeData> recipeListDinner;

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    FirebaseUser firebaseUser;

    RecyclerView rvBreakfast;
    RecyclerView rvLunch;
    RecyclerView rvDinner;

    public TrackerFragment() {

    }

    private static final String TAG = "TrackerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String key = firebaseUser.getUid();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Users/" + key);

        recipeListBreakfast = new ArrayList<>();
        recipeListDinner = new ArrayList<>();
        recipeListLunch = new ArrayList<>();


        View view = inflater.inflate(R.layout.tracker_fragment, container, false);
        rvBreakfast = (RecyclerView) view.findViewById(R.id.rv_addBreakfast);
        rvBreakfast.setHasFixedSize(true);


        rvDinner = (RecyclerView) view.findViewById(R.id.rv_addDinner);
        rvDinner.setHasFixedSize(true);


        rvLunch = (RecyclerView) view.findViewById(R.id.rv_addLunch);
        rvLunch.setHasFixedSize(true);


        rvBreakfast.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDinner.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvLunch.setLayoutManager(new LinearLayoutManager(getActivity()));

        addDataToRecyclerViews();


        //Adding touch helpers to swipe data from the Recycler view

        ItemTouchHelper.SimpleCallback breakfastHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                deleteDataFromRecyclerView(position, recipeListBreakfast);

            }
        };
        ItemTouchHelper breakfastTouchHelper = new ItemTouchHelper(breakfastHelper);
        breakfastTouchHelper.attachToRecyclerView(rvBreakfast);

        ItemTouchHelper.SimpleCallback lunchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                deleteDataFromRecyclerView(position, recipeListLunch);

            }
        };
        ItemTouchHelper lunchTouchHelper = new ItemTouchHelper(lunchHelper);
        lunchTouchHelper.attachToRecyclerView(rvLunch);

        ItemTouchHelper.SimpleCallback dinnerHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                deleteDataFromRecyclerView(position, recipeListDinner);

            }
        };
        ItemTouchHelper dinnerTouchHelper = new ItemTouchHelper(dinnerHelper);
        dinnerTouchHelper.attachToRecyclerView(rvDinner);


        buttonAddBreakfast = (Button) view.findViewById(R.id.button_addBreakfast);
        buttonAddLunch = (Button) view.findViewById(R.id.button_addLunch);
        buttonAddDinner = (Button) view.findViewById(R.id.button_addDinner);
        buttonAddBreakfast = (Button) view.findViewById(R.id.button_addBreakfast);

        textViewBreakfast = (TextView) view.findViewById(R.id.tv_breakfast);
        textViewLunch = (TextView) view.findViewById(R.id.tv_lunch);
        textViewDinner = (TextView) view.findViewById(R.id.tv_dinner);

        buttonAddBreakfast.setOnClickListener(this);
        buttonAddLunch.setOnClickListener(this);
        buttonAddDinner.setOnClickListener(this);

        return view;

    }

    private void deleteDataFromRecyclerView(int position, List<RecipeData> recipeListMeal) {
        RecipeData recipeData = recipeListMeal.get(position);
        String id = recipeData.getChildKey();
        String mealTitle = recipeData.getMealTitle();
        recipeListMeal.remove(position);
        Log.v(TAG, mealTitle);
        mDatabaseReference.child(mealTitle).child(id).removeValue();
        addDataToRecyclerViews();
        Toast.makeText(getActivity(), recipeData.getRecipe().getLabel() + " deleted", Toast.LENGTH_SHORT).show();
    }

    private void addDataToRecyclerViews() {

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Context context = getActivity();

                recipeListBreakfast.clear();
                recipeListDinner.clear();
                recipeListLunch.clear();

                if (!(dataSnapshot.child("Breakfast").getChildren() == null)) {
                    for (DataSnapshot snapshot : dataSnapshot.child("Breakfast").getChildren()) {
                        recipeListBreakfast.add(snapshot.getValue(RecipeData.class));
                    }
                    CustomTrackerAdapter adapter = new CustomTrackerAdapter(recipeListBreakfast, context);
                    adapter.notifyDataSetChanged();
                    rvBreakfast.setAdapter(adapter);
                }

                if (!(dataSnapshot.child("Lunch").getChildren() == null)) {
                    for (DataSnapshot snapshot : dataSnapshot.child("Lunch").getChildren()) {
                        recipeListLunch.add(snapshot.getValue(RecipeData.class));
                    }
                    CustomTrackerAdapter adapter = new CustomTrackerAdapter(recipeListLunch, context);
                    adapter.notifyDataSetChanged();
                    rvLunch.setAdapter(adapter);
                }

                if (!(dataSnapshot.child("Dinner").getChildren() == null)) {
                    for (DataSnapshot snapshot : dataSnapshot.child("Dinner").getChildren()) {
                        recipeListDinner.add(snapshot.getValue(RecipeData.class));
                    }
                    CustomTrackerAdapter adapter = new CustomTrackerAdapter(recipeListDinner, context);
                    adapter.notifyDataSetChanged();
                    rvDinner.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        String mealTitle;
        switch (view.getId()) {
            case R.id.button_addBreakfast:
                intent = new Intent(getActivity(), SearchActivity.class);
                mealTitle = textViewBreakfast.getText().toString();
                intent.putExtra(AppConstants.MEAL_TITLE, mealTitle);
                startActivity(intent);
                break;

            case R.id.button_addLunch:
                intent = new Intent(getActivity(), SearchActivity.class);
                mealTitle = textViewLunch.getText().toString();
                intent.putExtra(AppConstants.MEAL_TITLE, mealTitle);
                startActivity(intent);
                break;

            case R.id.button_addDinner:
                intent = new Intent(getActivity(), SearchActivity.class);
                mealTitle = textViewDinner.getText().toString();
                intent.putExtra(AppConstants.MEAL_TITLE, mealTitle);
                startActivity(intent);
                break;

            default:
                Log.v(TAG, "No button id found");

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Recipe recipe = data.getParcelableExtra(AppConstants.RECIPE_INTENT);
                Log.v(TAG, recipe.getLabel());

            }
        }
    }

}
