package com.societtee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.adapter.FacilitiesRecyclerViewAdapter;
import com.adapter.ServicesRecyclerViewAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bean.FacilitiyDataObject;
import com.helper.DividerItemDecoration;
import com.helper.RequiredFunction;
import com.helper.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Facilities extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "FacilitiesActivity";
    ArrayList<FacilitiyDataObject> results = new ArrayList<>();
    URL url;
    RequiredFunction rf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        url = new URL();
        rf = new RequiredFunction();

        getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.facilities_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, GridLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter = new FacilitiesRecyclerViewAdapter(results,getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((FacilitiesRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                                  FacilitiesRecyclerViewAdapter.MyClickListener() {
                                                                                    @Override
                                                                                    public void onItemClick(int position, View v) {
                                                                                        Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                        //Toast.makeText(getApplicationContext(), "this is click " + position, Toast.LENGTH_SHORT).show();

                                                                                        //Intent showAlbum = new Intent(Services.this, AlbumImageGallery.class);
                                                                                        //showAlbum.putExtra("albumName",results.get(position).getAlbumName());
                                                                                        //startActivity(showAlbum);
                                                                                    }
                                                                                });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.facilities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.main_menu) {
            Intent main_menu = new Intent(Facilities.this,MainMenu.class);
            startActivity(main_menu);
        } else if (id == R.id.album) {
            Intent album = new Intent(Facilities.this,Album.class);
            startActivity(album);
        } else if (id == R.id.all_conversation) {
            Intent conversation = new Intent(Facilities.this,AllConversations.class);
            startActivity(conversation);
        } else if (id == R.id.poll_list) {
            Intent poll = new Intent(Facilities.this,ListPolls.class);
            startActivity(poll);
        }else if (id == R.id.buzz) {
            Intent buzz = new Intent(Facilities.this,Buzz.class);
            startActivity(buzz);
        }else if (id == R.id.services) {
            Intent services = new Intent(Facilities.this,Services.class);
            startActivity(services);
        }
        else if (id == R.id.my_profile) {
            Intent services = new Intent(Facilities.this,MyProfile.class);
            startActivity(services);
        }
        else if (id == R.id.facilities) {
            Intent services = new Intent(Facilities.this,Facilities.class);
            startActivity(services);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getDataSet() {
        //sending request for loading cover image of album
        String JSON_URL = "http://"+url.ip+"/SocietteeWebservices/GetFacilities.php";
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
                        Toast.makeText(Facilities.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
    //send request ends

    public void getObject(JSONArray response)
    {
        try {
            JSONArray jsonArray = response;
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject =jsonArray.getJSONObject(i);
                String facility_id= jsonObject.getString("facilityId");
                String facility_name=jsonObject.getString("facilityName");
                String facility_description=jsonObject.getString("description");
                String facility_icon=jsonObject.getString("facilityIcon");
                String deposite=jsonObject.getString("deposite");
                String availableFlag=jsonObject.getString("availableFlag");

                String imagePath="http://"+url.ip+"/SocietteeWebservices/FacilitiesImages/";
                FacilitiyDataObject facilitiyDataObject =new FacilitiyDataObject(facility_id,facility_name,facility_description,imagePath.concat(facility_icon),deposite,availableFlag);
                Log.d("serviceDataObject ", facilitiyDataObject.toString());
                results.add(facilitiyDataObject);
            }
            mRecyclerView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
