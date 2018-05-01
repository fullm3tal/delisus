package com.example.dakaku.delisus.Helpers;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.dakaku.delisus.Listeners.ItemSwipeListener;

public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {

    ItemSwipeListener swipeListenerAdapter;


    public SimpleItemTouchHelper(ItemSwipeListener adapter) {
        swipeListenerAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        swipeListenerAdapter.itemDismissed(position);
    }
}
