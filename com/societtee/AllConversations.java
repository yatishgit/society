package com.societtee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.adapter.ConversationRecyclerViewAdapter;
import com.bean.ConversationDataObject;
import com.helper.DividerItemDecoration;
import com.helper.RequiredFunction;
import com.helper.URL;

import java.util.ArrayList;

public class AllConversations extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";
    URL url;
    RequiredFunction rf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_conversations);

        url = new URL();
        rf = new RequiredFunction();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ConversationRecyclerViewAdapter(getDataSet(),getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }
    @Override
    protected void onResume() {
        super.onResume();
        ((ConversationRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                          ConversationRecyclerViewAdapter.MyClickListener() {
                                                                              @Override
                                                                              public void onItemClick(int position, View v) {
                                                                                  Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                              }
                                                                          });
    }

    private ArrayList<ConversationDataObject> getDataSet() {
        ArrayList results = new ArrayList<ConversationDataObject>();
        for (int index = 0; index < 5; index++) {
            ConversationDataObject obj = new ConversationDataObject("yatish "+index,"date "+index,"time "+index,"title "+index,"description "+index,"http://"+url.ip+"/SocietteeWebservices/Album/Album1/arcanine.png");
            results.add(index, obj);
        }
        ConversationDataObject obj = new ConversationDataObject("yatish ","date ","time ","title ","description kjsvcsdcnslkcnlclsclskdlcksdlckmlskclscnmslnkclnkscslknclsknclskdnclsdknclsdknclknclksdnclskcnlsknc k naslkd lasdjnd d ddask d alsd ldjad aldk","");
        results.add(obj);
        return results;
    }
}
