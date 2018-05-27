package com.example.gbv_b.lab_4_my_android;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoPlayer = findViewById(R.id.videoPlayer);
        Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoPlayer.setVideoURI(myVideoUri);
        videoPlayer.requestFocus();
    }

    public void play(View view) {
        videoPlayer.start();
    }

    public void pause(View view) {
        videoPlayer.pause();
    }

    public void stop(View view) {
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

}
