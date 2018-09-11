package com.example.dakaku.delisus.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.adapters.CustomSliderAdapter;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

@BindView(R.id.textView_main_signIn)
    TextView textViewMainSignIn;

@BindView(R.id.textView_main_signUp)
    TextView textViewMainSignUp;

 @BindView(R.id.viewPager_main)
    ViewPager viewPager;

    @BindView(R.id.circle_indicator)
    CircleIndicator indicator;

 public CustomSliderAdapter customSliderAdapter;


 private static int currentPage=0;
 private int totalImageCount=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        customSliderAdapter =new CustomSliderAdapter(this);
        setImageSlider();

        textViewMainSignIn.setOnClickListener(this);
        textViewMainSignUp.setOnClickListener(this);

    }

    private void setImageSlider() {

       viewPager.setAdapter(customSliderAdapter);
       indicator.setViewPager(viewPager);

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {

             currentPage=position;

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

          final Handler handler=new Handler();
          final Runnable update=new Runnable() {

              @Override
              public void run() {
                  if(currentPage==totalImageCount){
                      currentPage=0;
                  }
                  viewPager.setCurrentItem(currentPage++,true);
              }
          };

        Timer swipeTimer=new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);
    }

    @Override
    public void onClick(View view) {
        Intent mainIntent;

        switch (view.getId()){

        // Implementing Onclick for the Views
            case R.id.textView_main_signIn:
                Log.v(TAG, "inside main Intent");
                mainIntent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                break;

            case R.id.textView_main_signUp:
                mainIntent=new Intent(MainActivity.this, SignupActivity.class);
                startActivity(mainIntent);
                break;

            default:
                Toast.makeText(MainActivity.this,"Invalid view", Toast.LENGTH_SHORT).show();
                return;
        }

    }
}
