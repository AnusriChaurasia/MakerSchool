package com.example.makerschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables
    Animation topAnimation, bottomAnimation;
    ImageView img;
    TextView logo, slogan;
    SharedPreferences introScreen;

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                introScreen = getSharedPreferences("introScreen", MODE_PRIVATE);
                boolean isFirstTime = introScreen.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = introScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent homeIntent = new Intent(MainActivity.this, Intro_Screen.class);
                    startActivity(homeIntent);
                    finish();//removes the activity

                }
                else{
                    Intent homeIntent = new Intent(MainActivity.this, Home.class);
                    startActivity(homeIntent);
                    finish();//removes the activity
                }


            }

        }, SPLASH_TIME_OUT);

        //Animation
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //hooks
        img = findViewById(R.id.imageView2);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        //assign animation
        img.setAnimation(topAnimation);
        logo.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

    }
}
