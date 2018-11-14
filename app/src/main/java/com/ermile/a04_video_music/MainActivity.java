package com.ermile.a04_video_music;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


    }

    public void oc_video (View view){
        startActivity ( new Intent ( this,activity_video.class ) );
    }

    public void oc_music(View view){
        startActivity ( new Intent ( this , activity_music.class) );
    }
}
