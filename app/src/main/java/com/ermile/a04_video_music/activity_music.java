package com.ermile.a04_video_music;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_music extends AppCompatActivity implements View.OnClickListener {

    Button bb, bbb;
    MediaPlayer mmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_music );

        mmm = MediaPlayer.create ( this,Uri.parse ( "http://dl.new-song.ir/music/96/12/Rastak%20Group%20Rana_(www.new-song.ir).mp3" ) );

        bb=findViewById ( R.id.bb );
        bbb=findViewById ( R.id.bbb );

        bb.setOnClickListener ( this );
        bbb.setOnClickListener ( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.bb:
                mmm.start ();
                break;

            case R.id.bbb:
                mmm.pause ();
                break;

            default:break;
        }
    }

    @Override
    protected void onStop() {
        Toast.makeText ( this , "Stop Music :)" , Toast.LENGTH_SHORT ).show ( );
        mmm.stop ();
        super.onStop ( );
    }
}
