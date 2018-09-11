package com.example.dakaku.delisus.helpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.dakaku.delisus.listeners.SimpleItemClickListener;

public class RecyclerItemClickHelper implements RecyclerView.OnItemTouchListener {
    private static final String TAG = "RecyclerItemClickHelper";

    private SimpleItemClickListener mSimpleItemClickListener;
    GestureDetector mGestureDetector;
    
    public RecyclerItemClickHelper(Context context, SimpleItemClickListener simpleItemClickListener) {
        mSimpleItemClickListener = simpleItemClickListener;

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.v(TAG,"OnSingleTapUp");
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mSimpleItemClickListener != null && mGestureDetector.onTouchEvent(e)) {
            mSimpleItemClickListener.onItemClick(rv.getChildAdapterPosition(childView));
            Log.v(TAG,"OnInterceptTouchEvent");
        }
        return false;
    }


    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
