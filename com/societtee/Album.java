package com.societtee;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.adapter.AlbumRecyclerViewAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import com.bean.AlbumDataObject;
import com.helper.DividerItemDecoration;
import com.helper.RequiredFunction;
import com.helper.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class Album extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";
    ArrayList<AlbumDataObject> results = new ArrayList<>();
    URL url;
    RequiredFunction rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        url = new URL();
        rf = new RequiredFunction();

        getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, GridLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter = new AlbumRecyclerViewAdapter(results,getApplicationContext());


    }

    @Override
    protected void onResume() {
        super.onResume();
        ((AlbumRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                             AlbumRecyclerViewAdapter.MyClickListener() {
                                                                                 @Override
                                                                                 public void onItemClick(int position, View v) {
                                                                                     Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                     //Toast.makeText(getApplicationContext(), "this is click " + position, Toast.LENGTH_SHORT).show();

                                                                                     Intent showAlbum = new Intent(Album.this, AlbumImageGallery.class);
                                                                                     showAlbum.putExtra("albumName",results.get(position).getAlbumName());
                                                                                     startActivity(showAlbum);
                                                                                 }
                                                                             });
    }


    private void getDataSet() {
        //sending request for loading cover image of album
        String JSON_URL = "http://"+url.ip+"/SocietteeWebservices/GetAlbumCoverImages.php";
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
                            Toast.makeText(Album.this,error.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);

            //request end
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void getObject(JSONArray response)
    {
        try {
            JSONArray jsonArray = response;
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject =jsonArray.getJSONObject(i);
               // AlbumDataObject album = new AlbumDataObject();

                //album.setAlbumName(jsonObject.getString("albumName"));
                String albumname=jsonObject.getString("albumName");
                //album.setAlbumDate(jsonObject.getString("albumDate"));
                String date=jsonObject.getString("albumDate");
                //album.setAlbumUploader(jsonObject.getString("albumUploader"));
                String uploader=jsonObject.getString("albumUploader");
                JSONArray coverImages=jsonObject.getJSONArray("coverImageUrl");
                String[] images =new String[coverImages.length()];
                for(int j=0;j<coverImages.length();j++)
                {
                    JSONObject jsonObject1 = coverImages.getJSONObject(j);
                    images[j] = jsonObject1.getString("image");
                }

                String imagePath="http://"+url.ip+"/SocietteeWebservices/Album/";
                AlbumDataObject album = new AlbumDataObject(albumname,date,uploader,imagePath.concat(images[0]));

                //album.setCoverImage(imagePath.concat(images[0]).toString());

                Log.d("ss ", album.toString());
                results.add(album);

            }

            mRecyclerView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
