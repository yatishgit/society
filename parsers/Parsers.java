package com.parsers;

import android.util.Log;

import com.bean.Album;
import com.bean.AlbumImages;
import com.bean.Booking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by TheLucifer on 12/15/2016.
 */
public class Parsers {


    public ArrayList<Album> parseAlbum(String response){

        ArrayList<Album> albums = new ArrayList<Album>();
        try {
            JSONObject json= new JSONObject(response);
            String res = json.getString("response");

            JSONArray jsonArray = new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++){
                Album album=new Album();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                album.setAlbumId(jsonObject.getString("albumId"));
                album.setSocietyId(jsonObject.getString("societyId"));
                album.setAlbumTitle(jsonObject.getString("albumTitle"));
                album.setDescription(jsonObject.getString("description"));

                ArrayList<AlbumImages> albumImages = new ArrayList<AlbumImages>();
                JSONArray imageArray = new JSONArray(jsonObject.getString("images"));
                for (int j=0;i<imageArray.length();j++){
                    AlbumImages images = new AlbumImages();
                    JSONObject imageObject = imageArray.getJSONObject(j);
                    images.setImageId(imageObject.getString("imageId"));
                    images.setAlbumId(imageObject.getString("albumId"));
                    images.setSocietyId(imageObject.getString("societyId"));
                    images.setImage(imageObject.getString("image"));
                    albumImages.add(images);
                }
                album.setImages(albumImages);
                albums.add(album);
            }
        }
        catch(JSONException e){
            Log.d("JSON",e.getLocalizedMessage());
        }
        return albums;
    }

    public ArrayList<Booking> parseBooking(String response)
    {
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        try{
            JSONObject json= new JSONObject(response);
            String res = json.getString("response");

            JSONArray jsonArray = new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++){
                Booking booking = new Booking();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                booking.setBookingId(jsonObject.getString("bookingId"));
                booking.setBookingDate(jsonObject.getString("bookingDate"));
                booking.setUserId(jsonObject.getString("userId"));
                booking.setFacilityId(jsonObject.getString("facilityId"));
                booking.setFromDate(jsonObject.getString("fromDate"));
                booking.setToDate(jsonObject.getString("toDate"));
                booking.setBuildingId(jsonObject.getString("buildingId"));
                booking.setFlatNo(jsonObject.getString("flatNo"));
                booking.setDescription(jsonObject.getString("description"));
                booking.setStatus(jsonObject.getString("status"));
                booking.setSocietyId(jsonObject.getString("societyId"));
                booking.setAmountDeposited(jsonObject.getString("amountDeposited"));
                booking.setAmountRefunded(jsonObject.getString("amountRefunded"));
                booking.set
            }
        }
        catch(JSONException e){
            Log.d("JSON",e.getLocalizedMessage());
        }


        return bookings;
    }

}
