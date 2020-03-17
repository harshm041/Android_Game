package com.example.test1.animalshadow;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton playbtn =(ImageButton)findViewById(R.id.play_btn);
        ImageView imgv =(ImageView)findViewById(R.id.game_logo);
        ImageView img_1 =(ImageView)findViewById(R.id.img1);
        ImageView img_2 =(ImageView)findViewById(R.id.img2);
        ImageView img_3 =(ImageView)findViewById(R.id.img3);
        ImageView img_4 =(ImageView)findViewById(R.id.img4);
        Button quitbtn=(Button)findViewById(R.id.quitbtn);
        //Blink Play Button using animation
        Animation animate = new AlphaAnimation(1,0);
        animate.setDuration(1200);
        animate.setInterpolator(new LinearInterpolator());
        animate.setRepeatCount(Animation.INFINITE);
        animate.setRepeatMode(Animation.REVERSE);
        playbtn.startAnimation(animate);

        RotateAnimation rotate1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate1.setInterpolator(new LinearInterpolator());
        rotate1.setRepeatCount(Animation.INFINITE);
        rotate1.setDuration(3000);

        RotateAnimation rotate2 = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate2.setInterpolator(new LinearInterpolator());
        rotate2.setRepeatCount(Animation.INFINITE);
        rotate2.setDuration(3000);

        img_1.startAnimation(rotate1);
        img_2.startAnimation(rotate2);
        img_3.startAnimation(rotate1);
        img_4.startAnimation(rotate2);
        //start game activity
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),game.class);
                startActivity(i);
            }
        });


        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


    }
}
