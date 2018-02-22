package com.example.dakaku.delisus.frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.R;

/**
 * Created by dakaku on 16/2/18.
 */

public class TrackerFragment extends Fragment {

    public TrackerFragment(){

    }

    private static final String TAG = "TrackerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.tracker_fragment,container,false);

        return view;

    }
}
