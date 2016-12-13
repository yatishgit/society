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
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bean.FacilitiyDataObject;
import com.helper.CustomVolleyRequest;
import com.societtee.R;

import java.util.ArrayList;

public class FacilitiesRecyclerViewAdapter extends RecyclerView
        .Adapter<FacilitiesRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "FacilityRecyclerViewAdapter";
    private ArrayList<FacilitiyDataObject> mDataset;
    private static MyClickListener myClickListener;
    private ImageLoader imageLoader;
    private Context context;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView facility_name;
        NetworkImageView facility_icon;
        TextView facility_description;
        Button check_availablity;


        public DataObjectHolder(View itemView) {
            super(itemView);
            facility_name = (TextView) itemView.findViewById(R.id.facility_name);
            facility_icon = (NetworkImageView) itemView.findViewById(R.id.facility_image);
            facility_description = (TextView) itemView.findViewById(R.id.facility_description);
            check_availablity = (Button)itemView.findViewById(R.id.check_availability_button);

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

    public FacilitiesRecyclerViewAdapter(ArrayList<FacilitiyDataObject> myDataset, Context context) {

        this.context = context;
        this.mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.facilities_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

       FacilitiyDataObject facilitiyDataObject = mDataset.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(facilitiyDataObject.getFacility_icon(), ImageLoader.getImageListener(holder.facility_icon, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        holder.facility_name.setText(facilitiyDataObject.getFacility_name());
        holder.facility_icon.setImageUrl(facilitiyDataObject.getFacility_icon(), imageLoader);
        holder.facility_description.setText(facilitiyDataObject.getFacility_description());
    }

    public void addItem(FacilitiyDataObject dataObj, int index) {
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
