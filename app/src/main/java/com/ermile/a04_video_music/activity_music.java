package com.ermile.a04_video_music;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class activity_music extends AppCompatActivity implements View.OnClickListener {

    Button bb, bbb;
    MediaPlayer mmm;

    SeekBar seekBar , seek_time;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_music );

        // add link for music
        mmm = MediaPlayer.create ( this,Uri.parse ( "http://dl.nicmusic.net/nicmusic/019/060/Relax%20Music%20-%20Nicmusic%20-%2001.mp3" ) );


        // add btn puse and playe
        //btn playe is visible
        bb=findViewById ( R.id.bb );
        bb.setVisibility ( View.VISIBLE );
        //btn puse is gone
        bbb=findViewById ( R.id.bbb );
        bbb.setVisibility ( View.GONE );

        // add put by onclick
        bb.setOnClickListener ( this );
        bbb.setOnClickListener ( this );


        //volume
        // add seekBar for edit volome
        seekBar = findViewById ( R.id.seekBar );
        // manage Audio
        audioManager = (AudioManager) getSystemService ( Context.AUDIO_SERVICE );
        // this max Progress
        int mxvolum = audioManager.getStreamMaxVolume ( AudioManager.STREAM_MUSIC );
        seekBar.setMax ( mxvolum );

        // this ---------o---- progress bar
        int curvolum = audioManager.getStreamVolume ( AudioManager.STREAM_MUSIC );
        seekBar.setProgress ( curvolum );

        // change volume
        seekBar.setOnSeekBarChangeListener ( new SeekBar.OnSeekBarChangeListener ( ) {
            @Override
            public void onProgressChanged(SeekBar seekBar , int progress , boolean fromUser) {
                audioManager.setStreamVolume ( AudioManager.STREAM_MUSIC, progress, 0 );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );



        //seek time audio
        // id progress seek_time
        seek_time =findViewById ( R.id.seek_time );
        //position
        seek_time.setMax ( mmm.getDuration () );
        seek_time.setProgress ( 0 );
        // set timer for progress
        new Timer ().scheduleAtFixedRate ( new TimerTask ()
            {
            @Override
            public void run() {
                seek_time.setProgress ( mmm.getCurrentPosition () );
                }
            }, 0 , 100 );

        seek_time.setOnSeekBarChangeListener ( new SeekBar.OnSeekBarChangeListener ( ) {
            @Override
            public void onProgressChanged(SeekBar seekBar , int progress , boolean fromUser) {
                if (mmm != null && fromUser){
                        mmm.seekTo ( progress );
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );

    }

    // this on click for btn's
    @Override
    public void onClick(View v) {
        switch (v.getId ()){

            //btn playe is start
            case R.id.bb:
                mmm.start ();
                break;

            //btn puse is start
            case R.id.bbb:
                mmm.pause ();
                break;

            default:break;
        }

        // put for visible & gone
        if (mmm.isPlaying ()){

            // if music is palye
            // btn play = GONE
            bb.setVisibility ( View.GONE );
            // btn puse = VISIBLE
            bbb.setVisibility ( View.VISIBLE );

            // else put!
        }else if ( !mmm.isPlaying ()){
            bb.setVisibility ( View.VISIBLE );
            bbb.setVisibility ( View.GONE );
        }
    }


    // if user lanche btn back music > stop!
    @Override
    protected void onStop() {

        if (mmm.isPlaying ()){
            Toast.makeText ( this , "Stop Music :)" , Toast.LENGTH_SHORT ).show ( );
            mmm.stop ();
        }
        super.onStop ( );
    }
}