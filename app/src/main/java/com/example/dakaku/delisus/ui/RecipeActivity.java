package com.example.dakaku.delisus.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.utils.AppConstants;
import com.example.dakaku.delisus.pojo.Recipe;
import com.example.dakaku.delisus.pojo.RecipeData;
import com.example.dakaku.delisus.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {

    private static final String TAG = "RecipeActivity";

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.tv_dishName)
    TextView tvDishName;

    @BindView(R.id.tv_dishEnergyId)
    TextView tvEnergy;

    @BindView(R.id.tv_dishCalciumId)
    TextView tvCalcium;

    @BindView(R.id.tv_dishCholesterolId)
    TextView tvCholesterol;

    @BindView(R.id.tv_dishProteinId)
    TextView tvProtein;

    @BindView(R.id.tv_dishZincId)
    TextView tvZinc;

    @BindView(R.id.tv_dishIronId)
    TextView tvIron;

    @BindView(R.id.tv_dishSugarId)
    TextView tvSugar;

    @BindView(R.id.tv_dishCarbsId)
    TextView tvCarbs;

    @BindView(R.id.tv_dishFatId)
    TextView tvFat;

    @BindView(R.id.tv_dishFiberId)
    TextView tvFiber;

    @BindView(R.id.fab)
    FloatingActionButton dishFab;

    DatabaseReference databaseRecipe;

    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ButterKnife.bind(this);
        final Recipe recipe = getIntent().getParcelableExtra(AppConstants.RECIPE_INTENT);
        final String textMealTitle = getIntent().getStringExtra(AppConstants.MEAL_TITLE);

        databaseRecipe = FirebaseDatabase.getInstance().getReference(AppConstants.FIREBASE_USERS);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            switch (textMealTitle) {
                case "Breakfast":
                    spinner.setSelection(0);
                    break;
                case "Lunch":
                    spinner.setSelection(1);
                    break;
                case "Dinner":
                    spinner.setSelection(2);
                    break;
                case "NO_MEAL":
                    spinner.setVisibility(View.GONE);
                    dishFab.setVisibility(View.GONE);
                    break;

                    default:
                        Log.v(TAG,"Null Title");
            }


        tvDishName.setText(recipe.getLabel());

        tvEnergy.setText(String.valueOf(recipe.getCalories()));

        tvFiber.setText(String.valueOf(recipe.getTotalNutrients().getfIBTG().getQuantity()));

        tvIron.setText(String.valueOf(recipe.getTotalNutrients().getfE().getQuantity()));

        tvProtein.setText(String.valueOf(recipe.getTotalNutrients().getpROCNT().getQuantity()));

        tvZinc.setText(String.valueOf(recipe.getTotalNutrients().getzN().getQuantity()));

        tvSugar.setText(String.valueOf(recipe.getTotalNutrients().getsUGAR().getQuantity()));

        tvCalcium.setText(String.valueOf(recipe.getTotalNutrients().getcA().getQuantity()));

        tvCarbs.setText(String.valueOf(recipe.getTotalNutrients().getcHOCDF().getQuantity()));

        tvCholesterol.setText(String.valueOf(recipe.getTotalNutrients().getcHOLE().getQuantity()));

        tvFat.setText(String.valueOf(recipe.getTotalNutrients().getfAT().getQuantity()));

        dishFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecipe(recipe);
            }
        });

    }

    private void setRecipe(Recipe recipe) {

        if (!(firebaseUser.getUid() == null)) {
            String mealTitle = spinner.getSelectedItem().toString();
            String id = firebaseUser.getUid();
            String childKey = databaseRecipe.child(id).child(mealTitle).push().getKey();
            RecipeData recipeData = new RecipeData(childKey, recipe, mealTitle);
            databaseRecipe.child(id).child(mealTitle).child(childKey).setValue(recipeData);
            Toast.makeText(RecipeActivity.this, recipe.getLabel() + " added", Toast.LENGTH_SHORT).show();
            finish();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
