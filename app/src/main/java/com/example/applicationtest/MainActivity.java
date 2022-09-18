package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentManager manager;
    public int i = 1;



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
                .add(R.id.frameLayout,fragment1)
//                .add(R.id.frameLayout,fragment2)
//                .add(R.id.frameLayout,fragment3)
//                .add(R.id.frameLayout,fragment4)
                ;
        transaction.commit();


        TextView textView_top = findViewById(R.id.textView_top);
        LinearLayout linearLayout1= findViewById(R.id.LinearLayout1);
        LinearLayout linearLayout2= findViewById(R.id.LinearLayout2);
        LinearLayout linearLayout3= findViewById(R.id.LinearLayout3);
        LinearLayout linearLayout4= findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right);
                transaction.replace(R.id.frameLayout,fragment1);
                transaction.commit();
                textView_top.setText("微信");

            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right);
                transaction.replace(R.id.frameLayout,fragment2);
                transaction.commit();
                textView_top.setText("通讯录");

            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right);
                transaction.replace(R.id.frameLayout,fragment3);
                transaction.commit();
                textView_top.setText("发现");

            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 4;
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right);
                transaction.replace(R.id.frameLayout,fragment4);
                transaction.commit();
                textView_top.setText("我的");

            }
        });




    }
}