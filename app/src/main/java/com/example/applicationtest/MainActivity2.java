package com.example.applicationtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.applicationtest.other.TwoActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("twh","oncreate");
        Intent intent=getIntent();
        String msg=intent.getStringExtra("msg");
        TextView textView_main2_01=findViewById(R.id.textView_main2_01);
        textView_main2_01.setText(msg);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("twh","onStart");
        Button button_main2_01 =findViewById(R.id.button_main2_01);
        button_main2_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("twh","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("twh","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("twh","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("twh","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("twh","onDestroy");
    }

}