package com.example.dakaku.delisus.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.dakaku.delisus.Adapters.CustomTabAdapter;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.frags.FavoriteFragment;
import com.example.dakaku.delisus.frags.NewsFragment;
import com.example.dakaku.delisus.frags.TrackerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    FirebaseUser mFirebaseUser;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
       mViewPager = (ViewPager) findViewById(R.id.viewPager_home);

       TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsLayout_home);
        tabLayout.setupWithViewPager(mViewPager);

        setUpViewPager(mViewPager);

    }

    private void setUpViewPager(ViewPager mViewPager) {

        CustomTabAdapter adapter = new CustomTabAdapter(getSupportFragmentManager());

        adapter.addFragment(new TrackerFragment(), "Calorie Tracker");
        adapter.addFragment(new NewsFragment(), "News");
        adapter.addFragment(new FavoriteFragment(), "Favorites");

        mViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_sign_out:

//                Creating a Dialog box for providing options to customer while logging out

                new AlertDialog.Builder(this).setMessage("Do you really want to logout ?")
                        .setPositiveButton(R.string.sign_out_yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton(R.string.sign_out_no, null).create().show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {

        //                Creating a Dialog box for providing options to customer while pressing back button

        new AlertDialog.Builder(this).setMessage("Do you really want to logout ?")
                .setPositiveButton(R.string.sign_out_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton(R.string.sign_out_no, null).create().show();
    }
}
