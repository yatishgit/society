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
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bean.ServiceDataObject;
import com.helper.CustomVolleyRequest;
import com.societtee.R;

import java.util.ArrayList;

public class ServicesRecyclerViewAdapter extends RecyclerView
        .Adapter<ServicesRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "AlbumRecyclerViewAdapter";
    private ArrayList<ServiceDataObject> mDataset;
    private static MyClickListener myClickListener;
    private ImageLoader imageLoader;
    private Context context;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        NetworkImageView service_image;
        TextView service_category;

        public DataObjectHolder(View itemView) {
            super(itemView);
            service_category  = (TextView) itemView.findViewById(R.id.service_category);
            service_image = (NetworkImageView) itemView.findViewById(R.id.service_image);

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

    public ServicesRecyclerViewAdapter(ArrayList<ServiceDataObject> myDataset, Context context) {

        this.context = context;
        this.mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

       ServiceDataObject serviceDataObject = mDataset.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(serviceDataObject.getServiceImageUrl(), ImageLoader.getImageListener(holder.service_image, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));


        holder.service_category.setText(serviceDataObject.getServiceType());
        holder.service_image.setImageUrl(serviceDataObject.getServiceImageUrl(),imageLoader);
    }

    public void addItem(ServiceDataObject dataObj, int index) {
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
