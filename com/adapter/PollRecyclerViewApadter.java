package com.adapter;

/**
 * Created by TheLucifer on 10/30/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bean.PollDataObject;
import com.societtee.R;

import java.util.ArrayList;

public class PollRecyclerViewApadter extends RecyclerView
        .Adapter<PollRecyclerViewApadter
        .DataObjectHolder> {
    private static String LOG_TAG = "PollRecyclerViewAdapter";
    private ArrayList<PollDataObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView name;
        TextView flat_no;
        TextView date;
        TextView time;
        TextView title;
        TextView description;
        TextView option;
        TextView option_count;
        CheckBox optionCheck;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.poll_creator_name);
            flat_no = (TextView) itemView.findViewById(R.id.poll_creator_flatno);
            date = (TextView) itemView.findViewById(R.id.poll_date);
            time = (TextView) itemView.findViewById(R.id.poll_time);
            title = (TextView) itemView.findViewById(R.id.poll_title);
            description = (TextView) itemView.findViewById(R.id.poll_description);
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

    public PollRecyclerViewApadter(ArrayList<PollDataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poll_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getPollCreator());
        holder.flat_no.setText(mDataset.get(position).getFlatNo());
        holder.date.setText(mDataset.get(position).getPollDate().toString());
        holder.time.setText(mDataset.get(position).getPollTime().toString());
        holder.title.setText(mDataset.get(position).getPollTitle());
        holder.description.setText(mDataset.get(position).getPollDescription());

    }

    public void addItem(PollDataObject dataObj, int index) {
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
