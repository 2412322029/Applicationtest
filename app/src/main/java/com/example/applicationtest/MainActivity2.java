package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerview;
    private myadapter myadapter;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        list= Arrays.asList(new String[]{"a","b","c","d"});

        recyclerview=findViewById(R.id.recyclerview);

        myadapter = new myadapter(this,list);
        RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(myadapter);


    }
}