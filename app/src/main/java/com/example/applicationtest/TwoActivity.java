package com.example.applicationtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TwoActivity extends AppCompatActivity {


    public String url= "http://127.0.0.1:5000/all";
    public String data = null;
    public String syncGet() {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    data = response.body().string();
                    Log.d("q",data);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return data;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twolayout);

        //https://cdn.unrun.top/blog/v/UMP45xUMP9.mp4
//        VideoView videoView = findViewById(R.id.videoView);
//        videoView.setVideoURI(Uri.parse("https://cdn.unrun.top/blog/v/UMP45xUMP9.mp4"));
//        videoView.start();
//        videoView.requestFocus();

        Button button = findViewById(R.id.button_two1);
        TextView textView = findViewById(R.id.textView_two1);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=syncGet();
                textView.setText(data);
            }
        });
    }





}