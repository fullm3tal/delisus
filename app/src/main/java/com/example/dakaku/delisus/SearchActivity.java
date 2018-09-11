package com.example.dakaku.delisus;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.adapters.CustomSearchAdapter;
import com.example.dakaku.delisus.listeners.RVItemClick;
import com.example.dakaku.delisus.network.RetrofitApi;
import com.example.dakaku.delisus.network.RestClient;
import com.example.dakaku.delisus.pojo.FoodApiHits;
import com.example.dakaku.delisus.pojo.FoodData;
import com.example.dakaku.delisus.pojo.Recipe;
import com.example.dakaku.delisus.ui.RecipeActivity;
import com.example.dakaku.delisus.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,RVItemClick {

    private static final String TAG = "SearchActivity";

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.rv_searchActivity)
    RecyclerView recyclerView;

    @BindView(R.id.text_meal)
    TextView tv_mealTitle;

    String textMealTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        textMealTitle =getIntent().getStringExtra(AppConstants.MEAL_TITLE);
        tv_mealTitle.setText(textMealTitle);
        Toolbar toolbar = findViewById(R.id.app_searchBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(10);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Setting up the SearchableInfo
        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);

    }

    //onNewIntent() is used to display the data received from the voiceSearchButton into SearchView
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String extraQuery = intent.getStringExtra(SearchManager.QUERY);
            searchView.setQuery(String.valueOf(extraQuery), false);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void getDataFromApi(String newText) {

        RestClient.getInstance().getRecipes(newText,
                AppConstants.APP_ID,
                AppConstants.APP_KEY,
                AppConstants.START_INDEX,
                AppConstants.END_INDEX).enqueue(new Callback<FoodData>() {
            @Override
            public void onResponse(Call<FoodData> call, Response<FoodData> response) {
                FoodData foodData = response.body();
                int dataSize = foodData.getHits().size();
                List<FoodApiHits> foodApiHitsList = foodData.getHits();

                CustomSearchAdapter customAdapter = new CustomSearchAdapter(foodApiHitsList, SearchActivity.this, SearchActivity.this);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<FoodData> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Retrofit Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        getDataFromApi(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onRecyclerItemClick(Recipe recipe) {
        Intent intent=new Intent(SearchActivity.this, RecipeActivity.class);
        intent.putExtra(AppConstants.RECIPE_INTENT,recipe);
        intent.putExtra(AppConstants.MEAL_TITLE,textMealTitle);
        startActivity(intent);
    }
}
