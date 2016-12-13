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
import com.android.volley.toolbox.NetworkImageView;
import com.bean.ConversationDataObject;
import com.helper.CustomVolleyRequest;
import com.societtee.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ConversationRecyclerViewAdapter extends RecyclerView
        .Adapter<ConversationRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "ConversationRecyclerViewAdapter";
    private ArrayList<ConversationDataObject> mDataset;
    private static MyClickListener myClickListener;
    ImageLoader imageLoader=null;
    Context context=null;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView date;
        TextView time;
        TextView title;
        TextView description;
        NetworkImageView image;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date);
            time = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            image = (NetworkImageView) itemView.findViewById(R.id.image1);

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

    public ConversationRecyclerViewAdapter(ArrayList<ConversationDataObject> myDataset,Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conversation_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        ConversationDataObject conversationDataObject = mDataset.get(position);
        if(conversationDataObject.getImage()!=null || conversationDataObject.getImage()!="") {
            imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
            imageLoader.get(conversationDataObject.getImage(), ImageLoader.getImageListener(holder.image, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        }
        holder.name.setText(conversationDataObject.getName());
        holder.date.setText(conversationDataObject.getDate());
        holder.time.setText(conversationDataObject.getTime());
        holder.title.setText(conversationDataObject.getTitle());
        holder.description.setText(conversationDataObject.getDescription());
        if(conversationDataObject.getImage()!=null || conversationDataObject.getImage()!="")
        holder.image.setImageUrl(conversationDataObject.getImage(), imageLoader);
    }

    public void addItem(ConversationDataObject dataObj, int index) {
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
