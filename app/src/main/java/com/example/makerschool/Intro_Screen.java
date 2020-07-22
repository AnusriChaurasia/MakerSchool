package com.example.makerschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_Screen extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;
    SliderAdapter sliderAdapter;
    Button getStartedBtn;
    Animation animation;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro__screen);

        //hooks
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dots);
        getStartedBtn = findViewById(R.id.get_started_btn);

        //Call adapter
        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

     public void skip(View view){
        startActivity(new Intent(getApplicationContext(),Home.class));
        finish();
     }

     public void next(View view){
        viewPager.setCurrentItem(currentPos + 1);
     }

    private  void addDots(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i =0; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
            currentPos = position;
            if(position == 0){
                getStartedBtn.setVisibility(View.INVISIBLE);
            }
            else if (position == 1){
                getStartedBtn.setVisibility(View.INVISIBLE);
            }
            else{
                animation = AnimationUtils.loadAnimation(Intro_Screen.this, R.anim.bottom_animation);
                getStartedBtn.setAnimation(animation);
                getStartedBtn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
