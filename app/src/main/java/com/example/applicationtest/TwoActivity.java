package com.example.applicationtest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class TwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twolayout);

        //https://cdn.unrun.top/blog/v/UMP45xUMP9.mp4
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("https://cdn.unrun.top/blog/v/UMP45xUMP9.mp4"));
        videoView.start();
        videoView.requestFocus();




    }}