package com.societtee;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.adapter.AlbumRecyclerViewAdapter;
import com.adapter.MainMenuRecyclerViewAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bean.AlbumDataObject;
import com.bean.MainMenuDataObject;
import com.helper.DividerItemDecoration;
import com.helper.ImageAdapter;
import com.helper.RequiredFunction;
import com.helper.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "MainMenuRecyclerViewActivity";
    ArrayList<MainMenuDataObject> results = new ArrayList<>();
    URL url;
    RequiredFunction rf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //main_menu_recycler_view

        /*GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainMenu.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });*/

        url = new URL();
        rf = new RequiredFunction();

        results=getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.main_menu_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, GridLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter = new MainMenuRecyclerViewAdapter(results,getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MainMenuRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                                MainMenuRecyclerViewAdapter.MyClickListener() {
                                                                                 @Override
                                                                                 public void onItemClick(int position, View v) {
                                                                                     Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                                     //Toast.makeText(getApplicationContext(), "this is click " + position, Toast.LENGTH_SHORT).show();

                                                                                    // Intent showAlbum = new Intent(MainMenu.this, AlbumImageGallery.class);
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
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
            Intent main_menu = new Intent(MainMenu.this,MainMenu.class);
            startActivity(main_menu);
        } else if (id == R.id.album) {
            Intent album = new Intent(MainMenu.this,Album.class);
            startActivity(album);
        } else if (id == R.id.all_conversation) {
            Intent conversation = new Intent(MainMenu.this,AllConversations.class);
            startActivity(conversation);
        } else if (id == R.id.poll_list) {
            Intent poll = new Intent(MainMenu.this,ListPolls.class);
            startActivity(poll);
        }else if (id == R.id.buzz) {
            Intent buzz = new Intent(MainMenu.this,Buzz.class);
            startActivity(buzz);
        }else if (id == R.id.services) {
            Intent services = new Intent(MainMenu.this,Services.class);
            startActivity(services);
        }
        else if (id == R.id.my_profile) {
            Intent services = new Intent(MainMenu.this,MyProfile.class);
            startActivity(services);
        }
        else if (id == R.id.facilities) {
            Intent services = new Intent(MainMenu.this,Facilities.class);
            startActivity(services);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<MainMenuDataObject> getDataSet() {

        ArrayList<MainMenuDataObject> data = new ArrayList<>();
        String[] menuName = {"My Flat","My Society","Facilities","Directory","HelpDesk"};
        Integer[] menuImages = {
                R.drawable.my_flat,R.drawable.mysocietee,
                R.drawable.facilities,R.drawable.directory,
                R.drawable.helpdesk
        };

        for(int i=0;i<menuName.length;i++)
        {
            MainMenuDataObject mainMenuDataObject = new MainMenuDataObject(menuName[i],menuImages[i]);
            Log.d("main menu",mainMenuDataObject.toString());
            data.add(mainMenuDataObject);
        }
        return data;
       // mRecyclerView.setAdapter(mAdapter);
    }



}
