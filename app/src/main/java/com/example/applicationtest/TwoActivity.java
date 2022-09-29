package com.example.applicationtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class TwoActivity extends AppCompatActivity {


    public String url = "https://cdn.unrun.top/blog/output";
    public String data = null;
//    OkHttpClient client = new OkHttpClient().newBuilder().build();
//    Request request = new Request.Builder().url(url).build();
//    Response response = client.newCall(request).execute();
//    ResponseBody responseBody = response.body();
//    Log.d("http",responseBody);


    public TwoActivity() throws IOException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twolayout);


        Button button = findViewById(R.id.btn_yes);
        TextView textView = findViewById(R.id.textView_two1);
        EditText editText=findViewById(R.id.etext1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss =editText.getText().toString();
                textView.setText(ss);
            }
        });
    }


}