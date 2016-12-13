package com.societtee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private ImageView logo;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo=(ImageView)findViewById(R.id.splash_logo);
        Animation animation= AnimationUtils.loadAnimation(Splash.this, R.anim.splash_animation);
        logo.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Intent login = new Intent(Splash.this, Login.class);
                startActivity(login);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
