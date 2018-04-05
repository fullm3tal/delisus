package com.example.dakaku.delisus.frags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dakaku.delisus.AppConstants;
import com.example.dakaku.delisus.Pojo.Recipe;
import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by dakaku on 16/2/18.
 */

public class TrackerFragment extends Fragment implements View.OnClickListener{

    Button buttonAddBreakfast;
    Button buttonAddLunch;
    Button buttonAddDinner;
    TextView textViewBreakfast;
    TextView textViewLunch;
    TextView textViewDinner;

    public TrackerFragment(){

    }

    private static final String TAG = "TrackerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.tracker_fragment,container,false);

        buttonAddBreakfast=(Button)view.findViewById(R.id.button_addBreakfast);
        buttonAddLunch=(Button)view.findViewById(R.id.button_addLunch);
        buttonAddDinner=(Button)view.findViewById(R.id.button_addDinner);
        buttonAddBreakfast=(Button)view.findViewById(R.id.button_addBreakfast);

       textViewBreakfast=(TextView)view.findViewById(R.id.tv_breakfast);
        textViewLunch=(TextView)view.findViewById(R.id.tv_lunch);
        textViewDinner=(TextView)view.findViewById(R.id.tv_dinner);

        buttonAddBreakfast.setOnClickListener(this);
        buttonAddLunch.setOnClickListener(this);
        buttonAddDinner.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        String mealTitle;
      switch (view.getId()){
          case R.id.button_addBreakfast:
              intent=new Intent(getActivity(), SearchActivity.class);
              mealTitle=textViewBreakfast.getText().toString();
              intent.putExtra(AppConstants.MEAL_TITLE,mealTitle);
              startActivity(intent);
              break;

          case R.id.button_addLunch:
              intent=new Intent(getActivity(), SearchActivity.class);
              mealTitle=textViewLunch.getText().toString();
              intent.putExtra(AppConstants.MEAL_TITLE,mealTitle);
              startActivity(intent);
              break;

          case R.id.button_addDinner:
              intent=new Intent(getActivity(), SearchActivity.class);
              mealTitle=textViewDinner.getText().toString();
              intent.putExtra(AppConstants.MEAL_TITLE,mealTitle);
              startActivity(intent);
              break;

          default:
              Log.v(TAG,"No button id found");

      }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==RESULT_OK){
                Recipe recipe= data.getParcelableExtra(AppConstants.RECIPE_INTENT);
                Log.v(TAG,recipe.getLabel());

            }
        }
    }
}
