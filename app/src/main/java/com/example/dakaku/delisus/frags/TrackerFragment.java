package com.example.dakaku.delisus.frags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.Adapters.CustomTrackerAdapter;
import com.example.dakaku.delisus.AppConstants;
import com.example.dakaku.delisus.Helpers.RecyclerItemClickHelper;
import com.example.dakaku.delisus.Helpers.SimpleItemTouchHelper;
import com.example.dakaku.delisus.Listeners.RVItemClick;
import com.example.dakaku.delisus.Listeners.SimpleItemClickListener;
import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.SearchActivity;
import com.example.dakaku.delisus.ui.RecipeActivity;
import com.example.dakaku.delisus.Pojo.RecipeData;
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

    private static final String TAG = "TrackerFragment";
    Button buttonAddBreakfast;
    Button buttonAddLunch;
    Button buttonAddDinner;
    TextView textViewBreakfast;
    TextView textViewLunch;
    TextView textViewDinner;
    private List<RecipeData> recipeListBreakfast;
    private List<RecipeData> recipeListLunch;
    private List<RecipeData> recipeListDinner;
    DatabaseReference mDatabaseReference;
    FirebaseUser firebaseUser;
    RecyclerView rvBreakfast;
    RecyclerView rvLunch;
    RecyclerView rvDinner;

    public TrackerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String key = firebaseUser.getUid();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users/" + key);

        recipeListBreakfast = new ArrayList<>();
        recipeListDinner = new ArrayList<>();
        recipeListLunch = new ArrayList<>();

        final View view = inflater.inflate(R.layout.tracker_fragment, container, false);

        rvBreakfast = (RecyclerView) view.findViewById(R.id.rv_addBreakfast);
        rvBreakfast.setHasFixedSize(true);
        rvBreakfast.setItemViewCacheSize(10);
        rvBreakfast.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvBreakfast.addOnItemTouchListener(new RecyclerItemClickHelper(getActivity(), new SimpleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Recipe recipe = getRecipeListBreakfast().get(position).getRecipe();
                Intent intent = new Intent(getActivity(), RecipeActivity.class);
                intent.putExtra(AppConstants.RECIPE_INTENT, recipe);
                intent.putExtra(AppConstants.MEAL_TITLE, "NO_MEAL");
                startActivity(intent);
                Log.v(TAG, recipe + " Breakfast");
            }
        }));


        rvDinner = (RecyclerView) view.findViewById(R.id.rv_addDinner);
        rvDinner.setHasFixedSize(true);
        rvDinner.setItemViewCacheSize(10);
        rvDinner.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDinner.addOnItemTouchListener(new RecyclerItemClickHelper(getActivity(), new SimpleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Recipe recipe = getRecipeListDinner().get(position).getRecipe();
                Intent intent = new Intent(getContext(), RecipeActivity.class);
                intent.putExtra(AppConstants.RECIPE_INTENT, recipe);
                intent.putExtra(AppConstants.MEAL_TITLE, "NO_MEAL");
                startActivity(intent);
                Log.v(TAG, recipe + " Dinner");
            }
        }));

        rvLunch = (RecyclerView) view.findViewById(R.id.rv_addLunch);
        rvLunch.setHasFixedSize(true);
        rvLunch.setItemViewCacheSize(10);
        rvLunch.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvLunch.addOnItemTouchListener(new RecyclerItemClickHelper(getActivity(), new SimpleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Recipe recipe = getRecipeListLunch().get(position).getRecipe();
                Intent intent = new Intent(getActivity(), RecipeActivity.class);
                intent.putExtra(AppConstants.RECIPE_INTENT, recipe);
                intent.putExtra(AppConstants.MEAL_TITLE, "NO_MEAL");
                startActivity(intent);
                Log.v(TAG, recipe.getLabel() + " Lunch");
            }
        }));

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

                deleteDataFromRecyclerView(position, getRecipeListBreakfast());

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

                deleteDataFromRecyclerView(position, getRecipeListLunch());

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

                deleteDataFromRecyclerView(position, getRecipeListDinner());

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
        final RecipeData recipeData = recipeListMeal.get(position);
        String id = recipeData.getChildKey();
        final String mealTitle = recipeData.getMealTitle();
        recipeListMeal.remove(position);
        Log.v(TAG, mealTitle);
        mDatabaseReference.child(mealTitle).child(id).removeValue();
        Toast.makeText(getActivity(), recipeData.getRecipe().getLabel() + " deleted", Toast.LENGTH_SHORT).show();
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(R.id.coordinatorLayout), "Recipe deleted", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String childKey = recipeData.getChildKey();
                mDatabaseReference.child(mealTitle).child(childKey).setValue(recipeData);
            }
        });
        snackbar.show();
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
                    rvBreakfast.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                if (!(dataSnapshot.child("Lunch").getChildren() == null)) {
                    for (DataSnapshot snapshot : dataSnapshot.child("Lunch").getChildren()) {
                        recipeListLunch.add(snapshot.getValue(RecipeData.class));
                    }
                    CustomTrackerAdapter adapter = new CustomTrackerAdapter(recipeListLunch, context);
                    rvLunch.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                if (!(dataSnapshot.child("Dinner").getChildren() == null)) {
                    for (DataSnapshot snapshot : dataSnapshot.child("Dinner").getChildren()) {
                        recipeListDinner.add(snapshot.getValue(RecipeData.class));
                    }
                    CustomTrackerAdapter adapter = new CustomTrackerAdapter(recipeListDinner, context);
                    rvDinner.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
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

    public List<RecipeData> getRecipeListBreakfast() {
        return recipeListBreakfast;
    }

    public List<RecipeData> getRecipeListLunch() {
        return recipeListLunch;
    }

    public List<RecipeData> getRecipeListDinner() {
        return recipeListDinner;
    }
}
