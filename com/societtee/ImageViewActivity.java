package com.societtee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.helper.CustomVolleyRequest;

public class ImageViewActivity extends AppCompatActivity {

    String albumName=null;
    String imageName=null;
    String url=null;
    NetworkImageView imageView;
    ImageLoader imageLoader=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        Intent getImage = getIntent();
        albumName = getImage.getStringExtra("albumName");
        imageName = getImage.getStringExtra("imageName");

       // Log.d("image name",imageName);
       // Log.d("album name",albumName);
        url = imageName;


        imageView = (NetworkImageView) findViewById(R.id.viewImage);

        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(imageView,
                R.drawable.check_mark, android.R.drawable
                        .ic_dialog_alert));
        imageView.setImageUrl(url, imageLoader);




    }
}
