package com.example.dakaku.delisus.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dakaku.delisus.R;

/**
 * Created by dakaku on 31/1/18.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    private static final String TAG = "CustomSwipeAdapter";

    private int []images={ R.drawable.fitness1,
            R.drawable.fitness2,
            R.drawable.fitness3,
            R.drawable.fitness4,
            R.drawable.fitness5 };

    private Context mContext;
    private LayoutInflater inflater;

   public CustomSwipeAdapter(Context context){
        super();
        mContext=context;
    }

    @Override
    public int getCount() {
        Log.v(TAG,"getCount called");
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.v(TAG,"isViewFromObject called");
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Log.v(TAG,"instantiateItem called "+position);

            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View myImageLayout = inflater.inflate(R.layout.image_slider, container, false);

        ImageView myImage=(ImageView)myImageLayout.findViewById(R.id.image_for_slider);
        myImage.setImageResource(images[position]);
        container.addView(myImageLayout);

        return myImageLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.v(TAG,"destroyItem called "+position);
        container.removeView((LinearLayout)object);
    }
}
