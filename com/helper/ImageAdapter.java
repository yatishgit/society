package com.helper;

/**
 * Created by TheLucifer on 10/16/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.societtee.R;

import static android.support.v7.widget.RecyclerView.*;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {


        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView optionName;
        ViewHolder holder;


        if (convertView == null) {
            imageView = new ImageView(mContext);
            optionName = new TextView(mContext);

            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
            imageView.setBackgroundColor(mContext.getResources().getColor(R.color.white));

            optionName.setText(option[position]);
            optionName.setTextColor(mContext.getResources().getColor(R.color.black));
            optionName.setPadding(5,5,5,5);

        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public String[] option = {"My Flat","My Society","Facilities","Directory","HelpDesk"};
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.my_flat,R.drawable.mysocietee,
            R.drawable.facilities,R.drawable.directory,
            R.drawable.helpdesk
    };
}