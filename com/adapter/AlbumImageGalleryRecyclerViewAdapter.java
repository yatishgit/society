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

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bean.AlbumDataObject;
import com.bean.AlbumImageGalleryDataObject;
import com.helper.CustomVolleyRequest;
import com.societtee.R;

import java.util.ArrayList;

public class AlbumImageGalleryRecyclerViewAdapter extends RecyclerView
        .Adapter<AlbumImageGalleryRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "AlbumImageGalleryRecyclerViewAdapter";
    private ArrayList<AlbumImageGalleryDataObject> mDataset;
    private static MyClickListener myClickListener;
    private ImageLoader imageLoader;
    private Context context;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        NetworkImageView gallery_image;


        public DataObjectHolder(View itemView) {
            super(itemView);
            gallery_image = (NetworkImageView) itemView.findViewById(R.id.album_gallery_image);

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

    public AlbumImageGalleryRecyclerViewAdapter(ArrayList<AlbumImageGalleryDataObject> myDataset,Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_image_gallery_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        AlbumImageGalleryDataObject albumGallery = mDataset.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(albumGallery.getAlbumImages(), ImageLoader.getImageListener(holder.gallery_image, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));


        holder.gallery_image.setImageUrl(albumGallery.getAlbumImages(),imageLoader);
    }

    public void addItem(AlbumImageGalleryDataObject dataObj, int index) {
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
