package com.societtee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.adapter.PollRecyclerViewApadter;
import com.bean.ConversationDataObject;
import com.bean.PollDataObject;
import com.helper.DividerItemDecoration;

import java.util.ArrayList;

public class ListPolls extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "ListPollsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_polls);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_polls_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PollRecyclerViewApadter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }


    @Override
    protected void onResume() {
        super.onResume();
        ((PollRecyclerViewApadter) mAdapter).setOnItemClickListener(new
                                                                            PollRecyclerViewApadter.MyClickListener() {
                                                                                        @Override
                                                                                        public void onItemClick(int position, View v) {
                                                                                            Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                        }
                                                                                    });
    }

    private ArrayList<PollDataObject> getDataSet() {
        ArrayList results = new ArrayList<ConversationDataObject>();
        for (int index = 0; index < 20; index++) {
            String option[]={"oprtion1","option2"};
            String optionCount[]={"2","3"};
            PollDataObject obj = new PollDataObject("yatish","title","date","time","flat number","description","poll expiry","poll question");
            results.add(index, obj);
        }
        return results;
    }

}
