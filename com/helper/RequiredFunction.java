package com.helper;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.widget.Toast;

import com.societtee.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TheLucifer on 3/17/2016.
 */
public class RequiredFunction {

    //checks network status
    public boolean isConnected(Activity a){
        ConnectivityManager connMgr = (ConnectivityManager)a.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    //returns result in string format
    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
        inputStream.close();
        return result;
    }


    //validation functions
    public boolean validEmail(String email) {
        if(!email.isEmpty()&& email!=null)
        {
            if(email.contains("@"))
            {
                return true;
            }
        }
        return false;
    }


    public boolean validPass(String text) {
        if(!text.isEmpty()&& text!=null)
        {
            if(text.length()>=1)
            {
                return true;
            }
        }
        return false;
    }

    public String checkResponse(String response,Activity activity)
    {
        String res=null;
        try {
            JSONObject jsonResponse = new JSONObject(response);
            res=jsonResponse.getString("response");
            if(res.equalsIgnoreCase("failure")) {
                Toast.makeText(activity.getApplicationContext(), R.string.invalid_username, Toast.LENGTH_SHORT).show();
                return "failure";
            }
            else {
                return res;
            }
        }
        catch(JSONException e){
            Log.d("Societtee","JSONException "+e.getLocalizedMessage());
        }

        return null;
    }


    public boolean validText(String text) {
        if(!text.isEmpty()&& text!=null)
        {

                return true;

        }
        return false;
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validContact(String contact)
    {
        return PhoneNumberUtils.isGlobalPhoneNumber(contact);
    }


}
