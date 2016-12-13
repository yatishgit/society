package com.societtee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.helper.RequiredFunction;
import com.helper.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView forgot_password;
    private AutoCompleteTextView society_name;
    private EditText username;
    private EditText password;
    private Button login;
    private RequiredFunction rf;
    private URL url;
    private String login_url = null;

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_SOCIETYNAME = "societyId";

    public static final String TAG = "Login";
    List<String> society_names = new ArrayList<String>();
    List<String> societyId = new ArrayList<String>();
    public String societyNameJson=null;
    ArrayAdapter<String> dataAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rf = new RequiredFunction();
        url = new URL();

        //society_names.add("Please select society");
        username = (EditText)findViewById(R.id.username_edittext);
        password = (EditText)findViewById(R.id.password_edittext);
        login = (Button)findViewById(R.id.login_button);
        forgot_password = (TextView)findViewById(R.id.forgot_password_textview);
        society_name = (AutoCompleteTextView)findViewById(R.id.society_name_spinner);

        getSocietyNames();
        // Creating adapter for spinner
        dataAdapter = new ArrayAdapter<String>(Login.this,R.layout.simple_spinner_item, society_names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner

        society_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View arg0) {
                society_name.showDropDown();
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               final String user_name = username.getText().toString();
               final String pass = password.getText().toString();
               final String societyName = society_name.getText().toString();

               int id = society_names.indexOf(societyName);
               String society_id = societyId.get(id);

               //check internet is available or not
               if (rf.isConnected(Login.this)) {
                   //content validation
                   if (rf.validText(user_name) && rf.validText(societyName)) {
                       if (rf.validPass(pass)) {
                           CheckLogin(society_id, user_name, pass);
                       } else {
                           Toast.makeText(getApplicationContext(), R.string.invalid_password, Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(getApplicationContext(), R.string.invalid_username, Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(getApplicationContext(), R.string.no_internet, Toast.LENGTH_SHORT).show();
               }
           }
       });


        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),R.string.forgot_password,Toast.LENGTH_SHORT).show();
                Intent forgot_passowrd = new Intent(Login.this,ForgotPassword.class);
                startActivity(forgot_passowrd);

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void CheckLogin(final String societyId, final String userName,final String pass)
    {
        //String JSON_URL = "http://" + societyName.concat(url.login_url);
        String JSON_URL = "http://"+url.ip+"/SocietteeWebservices/CheckUserLogin.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put(KEY_USERNAME,userName);
                        params.put(KEY_PASSWORD,pass);
                        params.put(KEY_SOCIETYNAME,societyId);
                        return params;
                    }
                };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response)
    {
        Log.d(TAG, "showJSON: "+response.toString());
        String res=rf.checkResponse(response,Login.this);
        if(res.equalsIgnoreCase("Failure"))
        {
            //Toast.makeText(Login.this,R.string.invalid_username_password,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent mainMenu = new Intent(Login.this,MainMenu.class);
            startActivity(mainMenu);
        }

        /*if(response.equalsIgnoreCase("Failure"))
        {
            Toast.makeText(Login.this,R.string.invalid_username_password,Toast.LENGTH_SHORT).show();
        }
        else if(response.contains("error"))
        {
            Toast.makeText(Login.this,R.string.failed_to_connect, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(Login.this,R.string.some_error, Toast.LENGTH_SHORT).show();
        }*/
    }


    //request for society names

    private void getSocietyNames()
    {

        String JSON_URL = "http://"+url.ip+"/societteewebservices/GetSocietyNames.php";
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("response ",response.toString());
                            JSONObject jr= new JSONObject(response);
                            String res=jr.getString("response");

                            if(res.equalsIgnoreCase("failure"))
                                Toast.makeText(getApplicationContext(),R.string.failed_to_connect,Toast.LENGTH_SHORT).show();
                            else
                                populateSocietyNames(response);

                            Log.d("society names",society_names.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        String result=null;

    }

    private void populateSocietyNames(String response) throws JSONException {
        Log.d(TAG, "showJSON: "+response.toString());

        JSONObject jres =new JSONObject(response);
        String res = jres.getString("response");
        JSONArray jsonArray = new JSONArray(res);
        if(jsonArray.length()>0) {
            for (int i = 0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                society_names.add(jsonObject.getString("societyName"));
                societyId.add(jsonObject.getString("societyId"));
            }
        }


        society_name.setAdapter(dataAdapter);
    }
    //request for society names ends
}


