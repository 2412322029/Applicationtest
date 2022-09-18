package com.example.applicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class TabActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);//调用xml中tab
//        LinearLayout linearLayout2 = findViewById(R.id.LinearLayout2);
//        linearLayout2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.d("xh","called");
//                Intent intent = new Intent(TabActivity.this, TwoActivity.class);//设置切换对应activity
//                startActivity(intent);
//                Log.d("xh","is called");
//            }});
    }

}

