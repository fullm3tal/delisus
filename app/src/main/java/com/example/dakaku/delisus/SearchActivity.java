package com.example.dakaku.delisus;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    @BindView(R.id.search_view)
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        Toolbar toolbar=findViewById(R.id.app_searchBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Setting up the SearchableInfo
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    }


    //onNewIntent() is used to display the voice response received from the voiceSearchButton into SearchView

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String extraQuery=intent.getStringExtra(SearchManager.QUERY);
            searchView.setQuery(String.valueOf(extraQuery),false);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
