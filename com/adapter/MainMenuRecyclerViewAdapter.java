package com.adapter;

/**
 * Created by TheLucifer on 10/30/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.bean.MainMenuDataObject;
import com.societtee.R;

import java.util.ArrayList;

public class MainMenuRecyclerViewAdapter extends RecyclerView
        .Adapter<MainMenuRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MainMenuRecyclerViewAdapter";
    private ArrayList<MainMenuDataObject> mDataset;
    private static MyClickListener myClickListener;
    private ImageLoader imageLoader;
    private Context context;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        ImageView menu_image;
        TextView menu_name;

        public DataObjectHolder(View itemView) {
            super(itemView);
            menu_name = (TextView) itemView.findViewById(R.id.menu_name);
            menu_image = (ImageView) itemView.findViewById(R.id.menu_image);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MainMenuRecyclerViewAdapter(ArrayList<MainMenuDataObject> myDataset, Context context) {

        this.context = context;
        this.mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        MainMenuDataObject menu = mDataset.get(position);
        //imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        //imageLoader.get(String.valueOf(menu.getMenuImage()), ImageLoader.getImageListener(holder.menu_image, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));


        holder.menu_name.setText(menu.getMenuName());
        holder.menu_image.setImageResource(menu.getMenuImage());
    }

    public void addItem(MainMenuDataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
