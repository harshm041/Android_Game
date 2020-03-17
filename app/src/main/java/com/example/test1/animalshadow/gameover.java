package com.example.test1.animalshadow;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gameover extends AppCompatActivity {


    private int score,hgscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        Button plyagn =(Button)findViewById(R.id.playbtn);
        Button qut=(Button)findViewById(R.id.quitbtn);
        TextView scr1=(TextView)findViewById(R.id.scrview1);
        TextView scr2=(TextView)findViewById(R.id.scrview2);
        score=getIntent().getIntExtra("Score",0);
        hgscore=getIntent().getIntExtra("HighScore",0);

        plyagn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),game.class);
                startActivity(i);
            }
        });

        qut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    //to check if its a new highscore and, accordingly display old and new highscore
        if(score>hgscore)
        {
            scr1.setText("Old HighScore: "+hgscore);
            scr2.setText("New HighScore: "+score);
        }
        else //else if its not an highscore, show your score and old highscore
        {
            scr2.setText("Your Score: "+score);
            scr1.setText("HighScore: "+hgscore);
        }




    }



}
