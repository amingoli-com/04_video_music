package com.ermile.a04_video_music;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class activity_video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_video );

        // for playe video by net

        //id
        VideoView videoView = findViewById ( R.id.videoView );
        // set url
        videoView.setVideoURI ( Uri.parse ( "http://dl.rozmusic.com/Music%20Video/1396/11/06/Mohsen%20Chavoshi%20-%20Jomee_RozMusic.mp4" ) );
        // open lib MediaController for stop and play and set time play
        MediaController controller = new MediaController ( this );

        // set controller to video View
        controller.setAnchorView ( videoView );
        // set video View to controller
        videoView.setMediaController ( controller );

        //start this put
        videoView.start ();


        //! do not forget add INTERNET permission in android manifest !
        // cod is:
        // <uses-permission android:name="android.permission.INTERNET" />
    }
}
