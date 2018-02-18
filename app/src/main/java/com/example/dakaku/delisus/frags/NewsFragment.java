package com.example.dakaku.delisus.frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dakaku.delisus.R;

/**
 * Created by dakaku on 16/2/18.
 */

public class NewsFragment extends Fragment {

    private static final String TAG = "NewsFragment";
    TextView textView_news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.news_fragment,container,false);

        textView_news=(TextView) view.findViewById(R.id.tvNews_fragment);
        textView_news.setText(TAG);

        return view;

    }
}
