package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment fragment1, fragment2, fragment3, fragment4;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .add(R.id.frameLayout, fragment1)
//                .add(R.id.frameLayout,fragment2)
//                .add(R.id.frameLayout,fragment3)
//                .add(R.id.frameLayout,fragment4)
                ;
        transaction.commit();


        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.LinearLayout1:
                select(1);
                break;
            case R.id.LinearLayout2:
                select(2);
                break;
            case R.id.LinearLayout3:
                select(3);
                break;
            case R.id.LinearLayout4:
                select(4);
                break;
        }


    }

    private void select(int i) {
        TextView textView_top = findViewById(R.id.textView_top);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.slide_out_right);
        switch (i) {
            case 1:
                transaction.replace(R.id.frameLayout, fragment1)
                        .commit();
                textView_top.setText("微信");
                ;
                break;
            case 2:
                transaction.replace(R.id.frameLayout, fragment2)
                        .commit();
                textView_top.setText("通讯录");
                ;
                break;
            case 3:
                transaction.replace(R.id.frameLayout, fragment3)
                        .commit();
                textView_top.setText("发现");
                ;
                break;
            case 4:
                transaction.replace(R.id.frameLayout, fragment4)
                        .commit();
                textView_top.setText("我的");
                ;
                break;
        }
    }
}