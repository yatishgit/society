package com.societtee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.adapter.AlbumImageGalleryRecyclerViewAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bean.AlbumDataObject;
import com.bean.AlbumImageGalleryDataObject;
import com.helper.DividerItemDecoration;
import com.helper.RequiredFunction;
import com.helper.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlbumImageGallery extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "AlbumImageGallery";
    ArrayList<AlbumImageGalleryDataObject> gallery = new ArrayList<>();
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_SOCIETYNAME = "societyName";
    public static final String KEY_ALBUMNAME = "albumName";

    String albumName=null;
    URL url;
    RequiredFunction rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_image_gallery);

        url = new URL();
        rf = new RequiredFunction();

        Intent i = getIntent();
        albumName = i.getStringExtra("albumName").toString();
        getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.album_image_gallery_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AlbumImageGalleryRecyclerViewAdapter(gallery,getApplicationContext());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, GridLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((AlbumImageGalleryRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                                         AlbumImageGalleryRecyclerViewAdapter.MyClickListener() {
                                                                                             @Override
                                                                                             public void onItemClick(int position, View v) {
                                                                                                 Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                                 //Toast.makeText(getApplicationContext(), "this is click " + position, Toast.LENGTH_SHORT).show();
                                                                                                 Intent showImage = new Intent(AlbumImageGallery.this, ImageViewActivity.class);
                                                                                                 showImage.putExtra("imageName",gallery.get(position).getAlbumImages());
                                                                                                 showImage.putExtra("albumName",albumName);
                                                                                                 startActivity(showImage);
                                                                                             }
                                                                                         });
    }


    private void getDataSet() {
        String JSON_URL = "http://"+url.ip+"/SocietteeWebservices/GetAlbumImages.php?albumName=".concat(albumName);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("rsesponse ",response.toString());
                        getObject(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AlbumImageGallery.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }



    public void getObject(JSONArray response)
    {
        //  results = new ArrayList<>();

        try {
            JSONArray jsonArray = response;
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject =jsonArray.getJSONObject(i);

                String image = jsonObject.getString("image");
                String imagePath="http://"+url.ip+"/SocietteeWebservices/Album/".concat(image);
                AlbumImageGalleryDataObject obj = new AlbumImageGalleryDataObject(imagePath);
                gallery.add(obj);
            }
            mRecyclerView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
