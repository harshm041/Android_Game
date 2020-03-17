package com.example.test1.animalshadow;


        import androidx.appcompat.app.AppCompatActivity;


        import android.content.Context;

        import android.content.Intent;
        import android.database.Cursor;

        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import android.os.Bundle;
        import android.os.CountDownTimer;

        import android.view.View;

        import android.widget.Button;

        import android.widget.ImageView;

        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Arrays;
        import java.util.Collections;
        import java.util.Random;

public class game extends AppCompatActivity {

    //database helper class to store scores
    class MyDB extends SQLiteOpenHelper
    {
        MyDB(Context  c)
        {
            super(c,"scoresDB",null,1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String str ="create table highscore(score integer)";
            db.execSQL(str);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sr ="drop table if exists highscore";
            db.execSQL(sr);
            onCreate(db);
        }
    }

    MyDB mdb;
    SQLiteDatabase db;
    ImageView option1,option2,option3,option4,imageMain,icon;
    TextView status,ys,hs,time;
    Button next;
    CountDownTimer cdt;
    //List of colored images
    Integer[] images={
            R.drawable.animal1,
            R.drawable.animal2,
            R.drawable.animal3,
            R.drawable.animal4,
            R.drawable.animal5,
            R.drawable.animal6,
            R.drawable.animal7,
            R.drawable.animal8,
            R.drawable.animal9,
            R.drawable.animal10,
            R.drawable.animal11,
            R.drawable.animal12,
            R.drawable.animal13,
            R.drawable.animal14,
            R.drawable.animal15,
            R.drawable.animal16,
            R.drawable.animal17,
            R.drawable.animal18,
            R.drawable.animal19,
            R.drawable.animal20,

    };

    //List of shadow images
    Integer[] images_bw={
            R.drawable.animal1_bw,
            R.drawable.animal2_bw,
            R.drawable.animal3_bw,
            R.drawable.animal4_bw,
            R.drawable.animal5_bw,
            R.drawable.animal6_bw,
            R.drawable.animal7_bw,
            R.drawable.animal8_bw,
            R.drawable.animal9_bw,
            R.drawable.animal10_bw,
            R.drawable.animal11_bw,
            R.drawable.animal12_bw,
            R.drawable.animal13_bw,
            R.drawable.animal14_bw,
            R.drawable.animal15_bw,
            R.drawable.animal16_bw,
            R.drawable.animal17_bw,
            R.drawable.animal18_bw,
            R.drawable.animal19_bw,
            R.drawable.animal20_bw,



    };


    //List of number of all images / currently 4
    Integer[] images_numbers={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

    //variables
    int turn=1;
    int CorrectAnswer=0;
    int score=0;
    int chances=0;
    int hi=0;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        icon=(ImageView)findViewById(R.id.status_icon) ;
        option1=(ImageView)findViewById(R.id.option_1);
        option2=(ImageView)findViewById(R.id.option_2);
        option3=(ImageView)findViewById(R.id.option_3);
        option4=(ImageView)findViewById(R.id.option_4);
        imageMain=(ImageView)findViewById(R.id.shadow);
        ys=(TextView)findViewById(R.id.your_score);
        hs=(TextView)findViewById(R.id.highestscore);
        status=(TextView)findViewById(R.id.status);
        time=(TextView)findViewById(R.id.Time);
        next=(Button)findViewById(R.id.next);
        mdb=new  MyDB(this);

        //random shuffle the images
        Collections.shuffle(Arrays.asList(images_numbers));

        //set the images on the screen
        setImages();



        //Retrieve highest score from database
        try {
            db = mdb.getReadableDatabase();
            Cursor c = db.rawQuery("Select MAX(score) from highscore",null);
            if(c.moveToFirst())
            {
                do {
                    hi = c.getInt(0);
                }while(c.moveToNext());
            }

        } catch (Exception e) {}
        ys.setText("Your Score : "+score);
        hs.setText("Highest Score : "+hi);


        //Clicks
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                cdt.cancel();
                if(CorrectAnswer==1)
                {
                    score = score+4;
                    status.setText("Correct");
                    next.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.correct);

                }
                else
                {
                    status.setText("Wrong");
                    next.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Correct Answer is option  "+CorrectAnswer,Toast.LENGTH_SHORT).show();
                    if(score>0) {
                        score = score - 1;
                    }
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.wrong);
                    chances++;
                }
                //disable images
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                imageMain.setImageResource(images[images_numbers[turn]]);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                cdt.cancel();
                if(CorrectAnswer==2)
                {
                    score=score+4;
                    status.setText("Correct");
                    next.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.correct);

                }
                else
                {
                    status.setText("Wrong");
                    next.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Correct Answer is option  "+CorrectAnswer,Toast.LENGTH_SHORT).show();
                    if(score>0) {
                        score = score - 1;
                    }
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.wrong);
                    chances++;
                }
                //disable images
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                imageMain.setImageResource(images[images_numbers[turn]]);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                cdt.cancel();
                if(CorrectAnswer==3)
                {
                    score=score+4;
                    status.setText("Correct");
                    next.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.correct);

                }
                else
                {
                    status.setText("Wrong");
                    next.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Correct Answer is option  "+CorrectAnswer,Toast.LENGTH_SHORT).show();
                    if(score>0) {
                        score = score - 1;
                    }
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.wrong);
                    chances++;
                }
                //disable images
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                imageMain.setImageResource(images[images_numbers[turn]]);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                cdt.cancel();
                if(CorrectAnswer==4)
                {
                    score=score+4;
                    status.setText("Correct");
                    next.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.correct);

                }
                else
                {

                    status.setText("Wrong");
                    next.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Correct Answer is option  "+CorrectAnswer,Toast.LENGTH_SHORT).show();
                    if(score>0) {
                        score = score - 1;
                    }
                    icon.setVisibility(View.VISIBLE);
                    icon.setImageResource(R.drawable.wrong);
                    chances++;
                }
                //disable images
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                imageMain.setImageResource(images[images_numbers[turn]]);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //increase the turns and finish the game if 10 turns are passed
                turn++;
                ys.setText("Your Score : "+score);
                if(turn==19 || chances==3)
                {
                    checkEnd();
                }
                else
                {

                    setImages();
                }
                icon.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void setImages()
    {
        // determine which is the correct answer 1-4
        Random r = new Random();
        CorrectAnswer = r.nextInt(4)+1;
        counter=3;
        //generate random wrong answer

        int WrongAnswer1,WrongAnswer2,WrongAnswer3;

        do{
            WrongAnswer1=r.nextInt(4);

        }while(WrongAnswer1==images_numbers[turn]);

        do{
            WrongAnswer2=r.nextInt(4);

        }while(WrongAnswer2==images_numbers[turn] || WrongAnswer2==WrongAnswer1);

        do{
            WrongAnswer3=r.nextInt(4);

        }while(WrongAnswer3==images_numbers[turn] || WrongAnswer3==WrongAnswer2 || WrongAnswer3==WrongAnswer1);

        //set images for all answer
        switch (CorrectAnswer)
        {
            case 1:
                option1.setImageResource(images[images_numbers[turn]]);
                option2.setImageResource(images[WrongAnswer1]);
                option3.setImageResource(images[WrongAnswer2]);
                option4.setImageResource(images[WrongAnswer3]);
                break;
            case 2:
                option1.setImageResource(images[WrongAnswer1]);
                option2.setImageResource(images[images_numbers[turn]]);
                option3.setImageResource(images[WrongAnswer2]);
                option4.setImageResource(images[WrongAnswer3]);
                break;
            case 3:
                option1.setImageResource(images[WrongAnswer1]);
                option2.setImageResource(images[WrongAnswer2]);
                option3.setImageResource(images[images_numbers[turn]]);
                option4.setImageResource(images[WrongAnswer3]);
                break;
            case 4:
                option1.setImageResource(images[WrongAnswer1]);
                option2.setImageResource(images[WrongAnswer2]);
                option3.setImageResource(images[WrongAnswer3]);
                option4.setImageResource(images[images_numbers[turn]]);
                break;

        }

        //set images for the question
        imageMain.setImageResource(images_bw[images_numbers[turn]]);

        //null stuff
        status.setText("");
        next.setVisibility(View.INVISIBLE);

        option1.setEnabled(true );
        option2.setEnabled(true );
        option3.setEnabled(true );
        option4.setEnabled(true );

       cdt= new CountDownTimer(3000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time Left: "+String.valueOf(counter));
                counter--;

            }

           @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Time over",Toast.LENGTH_SHORT).show();
                next.setVisibility(View.VISIBLE);
               if(score>0) {
                   score = score - 2;
               }
                time.setText("Time Over!");
                chances++;
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                imageMain.setImageResource(images[images_numbers[turn]]);
            }
        }.start();

    }

    private void checkEnd() {


        db = mdb.getWritableDatabase();
        if (score > hi)
        {
            try
            {
                String q = "insert into highscore values('" + score + "')";
                db.execSQL(q);
                Toast.makeText(getApplicationContext(), "Congratulations! New HighScore " + score, Toast.LENGTH_LONG).show();
            } catch (SQLException e) {}
            db.close();
        }
        else
            {
            Toast.makeText(getApplicationContext(), "GameOver! Your Score is " + score, Toast.LENGTH_LONG).show();
            }
        Intent gameoverIntent=new Intent(getApplicationContext(),gameover.class);
        gameoverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        gameoverIntent.putExtra("Score",score);//passing current score  value to other activity
        gameoverIntent.putExtra("HighScore",hi);//passing highscore value to other activity
        startActivity(gameoverIntent);
    }

}

