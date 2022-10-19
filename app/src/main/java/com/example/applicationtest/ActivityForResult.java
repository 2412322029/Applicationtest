package com.example.applicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;





public class ActivityForResult extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.putExtra("msg", "ActivityForResult发送 finish");
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}