package com.example.applicationtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.applicationtest.other.musicAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment4 extends Fragment {

    private RecyclerView recyclerView;
    private Context context;
    private musicAdapter myadapter;
    private final List<String> namelist=new ArrayList<>();
    private final List<String> artistlist=new ArrayList<>();
    private final List<String> urllist=new ArrayList<>();
    private final List<String> coverlist=new ArrayList<>();


    private void getjson(){
        InputStream stream=getResources().openRawResource(R.raw.output);
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        String jsonStr="",line="";
        try {
            while ((line=reader.readLine())!=null){
                jsonStr+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jsonObject1 = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject1.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String artist = jsonObject.getString("artist");
                String url = jsonObject.getString("url");
                String cover = jsonObject.getString("cover");
                String lrc = jsonObject.getString("lrc");
                namelist.add(name);
                artistlist.add(artist);
                urllist.add(url);
                coverlist.add(cover);
//                lrclist.add(lrc);

//                Log.d("f4", String.valueOf(list));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.tab04, container, false);

        recyclerView = view.findViewById(R.id.recyclerview2);

        Viewinit();
        getjson();
        return view;



    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onStart() {
        super.onStart();




    }

    private void Viewinit() {
        context = this.getActivity();
        //fullview=getView();
        myadapter = new musicAdapter(context);
        //设置LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myadapter);
        myadapter.list(namelist,artistlist,urllist,coverlist);


    }



}