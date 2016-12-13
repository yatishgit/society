package com.societtee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.helper.RequiredFunction;
import com.helper.URL;

import java.util.HashMap;
import java.util.Map;

public class ForgotPassword extends AppCompatActivity {


    private EditText email;
    private Button submit;
    private RequiredFunction rf;
    private URL url;

    public static final String KEY_EMAIL = "email_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogot_password);

        rf = new RequiredFunction();
        url = new URL();

        email = (EditText)findViewById(R.id.email_edittext);
        submit = (Button)findViewById(R.id.submit_button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rf.emailValidator(email.getText().toString()))
                {
                    resetPassword();
                }
                else
                {
                    Toast.makeText(ForgotPassword.this, R.string.valid_email, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void resetPassword()
    {
        final String email_id = email.getText().toString();
        final String RESET_PASSWORD_URL="http://"+url.ip+"/SocietteeWebservices/PasswordReset.php";

        StringRequest passwordResetRequest = new StringRequest(Request.Method.POST, RESET_PASSWORD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("dsd",response);
                        if(response.equalsIgnoreCase("Success")){
                           //show dialog box for checking mail for reset password and navigate back to login screen
                            Toast.makeText(ForgotPassword.this,"Check mails for reset password",Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(ForgotPassword.this, Login.class);
                            startActivity(loginIntent);
                        }
                        else if(response.equalsIgnoreCase("Failure")){
                            Toast.makeText(ForgotPassword.this,R.string.invalid_email,Toast.LENGTH_SHORT).show();
                        }
                        else if(response.equalsIgnoreCase("error")){
                            Toast.makeText(ForgotPassword.this,R.string.failed_to_connect,Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(ForgotPassword.this,R.string.some_error,Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ForgotPassword.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email_id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(passwordResetRequest);
    }
}
