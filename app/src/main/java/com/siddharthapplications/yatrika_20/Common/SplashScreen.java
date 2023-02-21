package com.siddharthapplications.yatrika_20.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.siddharthapplications.yatrika_20.R;

public class SplashScreen extends AppCompatActivity {

    public ImageView imageLogo, imageTravel;
    public LinearLayout developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageLogo = findViewById(R.id.logo);
        Animation dropAnimation = AnimationUtils.loadAnimation(this, R.anim.drop);
        imageLogo.startAnimation(dropAnimation);


        imageTravel = findViewById(R.id.imageTravel);
        Animation liftAnimation = AnimationUtils.loadAnimation(this, R.anim.lift);
        imageTravel.startAnimation(liftAnimation);



        developer = findViewById(R.id.developerView);
        Animation devlist = AnimationUtils.loadAnimation(this, R.anim.lift);
        developer.startAnimation(devlist);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}