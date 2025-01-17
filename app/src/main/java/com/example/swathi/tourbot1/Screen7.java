package com.example.swathi.tourbot1;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Screen7 extends AppCompatActivity {
    Button end_tour_btn, pause_btn, chng_destn_btn, srch_website_btn, back_btn, ask_qstn;
    MediaPlayer mp;
    int paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);
        addListenerOnButton();


    }
    public void addListenerOnButton() {

        final Context context = this;

        end_tour_btn= (Button) findViewById(R.id.button_end_tour_screen7);
        //pause_btn = (Button) findViewById(R.id.button_pause_stdnt_srvcs);
        chng_destn_btn = (Button) findViewById(R.id.button_chng_destn_stdnt_srvcs);
        srch_website_btn = (Button) findViewById(R.id.button_srch_web_stdnt_srvcs);
        back_btn= (Button) findViewById(R.id.button_back_student_services);
        ask_qstn= (Button) findViewById(R.id.button_ask_qstn_student_services);


        end_tour_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Screen9.class);
                startActivity(intent);
            }

        });

        srch_website_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pdx.edu"));
                startActivity(intent);

            }

        });
        chng_destn_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, NewDestinationScreen.class);
                startActivity(intent);

            }

        });
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //Intent intent = new Intent(context, NewDestinationScreen.class);
                //startActivity(intent);
                finish();

            }

        });
        ask_qstn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Screen8.class);
                startActivity(intent);

            }

        });

    }

    public void play_func(View view)
    {
        if(mp==null)
        {
            mp = MediaPlayer.create(this, R.raw.studentservices);
            mp.start();
        }
        else if(!mp.isPlaying())
        {
            mp.seekTo(paused);
            mp.start();
        }

    }
    public  void stop_func(View view)
    {
        mp.release();
        mp = null;
    }
    public void pause_func(View view)
    {
        mp.pause();
        paused=mp.getCurrentPosition();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null) {
            mp.pause();
            if (isFinishing()) {
                mp.stop();
                mp.release();
            }
        }
    }

}
