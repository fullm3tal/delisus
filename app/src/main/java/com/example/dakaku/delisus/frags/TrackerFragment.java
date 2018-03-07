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

import com.example.dakaku.delisus.R;
import com.example.dakaku.delisus.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dakaku on 16/2/18.
 */

public class TrackerFragment extends Fragment {

    Button buttonAddBreakfast;

    public TrackerFragment(){

    }

    private static final String TAG = "TrackerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.tracker_fragment,container,false);

        buttonAddBreakfast=(Button)view.findViewById(R.id.button_addBreakfast);
        buttonAddBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
