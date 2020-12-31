package com.example.class15;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyLineraManger extends LinearLayoutManager {
    public MyLineraManger(Context context) {
        super(context);
    }

    public MyLineraManger(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MyLineraManger(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try{
        super.onLayoutChildren(recycler, state);
        }catch (IndexOutOfBoundsException e) {
            Log.e("problem", "meet a IOOBE in RecyclerView");
        }

    }
}
