package com.example.applicationtest.other;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.applicationtest.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private String nid ,id,classq,jishu,img_url,year,name,text,code,msg;
    private int page=1;
    private ImageView image_cover;
    private TextView mTv_responseText,text_nid,text_id,text_classq,text_jishu,text_img_url,text_year,text_name,text_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twolayout);
        Button mBtn_sendRequest = findViewById(R.id.btn_send_request);
        Button btn_p = findViewById(R.id.but_p);
        Button but_n = findViewById(R.id.but_n);
        mTv_responseText = findViewById(R.id.response_text);
        text_nid = findViewById(R.id.text_nid);
        text_id = findViewById(R.id.text_id);
        text_classq = findViewById(R.id.text_classq);
        text_jishu = findViewById(R.id.text_jishu);
        text_img_url = findViewById(R.id.text_img_url);
        text_year = findViewById(R.id.text_year);
        text_name = findViewById(R.id.text_name);
        text_text = findViewById(R.id.text_text);

        image_cover=findViewById(R.id.image_cover);
        mBtn_sendRequest.setOnClickListener(this);
        btn_p.setOnClickListener(this);
        but_n.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_request) {
            sendRequestWithOkHttp(page);

        }
        if (v.getId() == R.id.but_p) {
            Log.d("p",""+page);
            if (page<=1){
                mTv_responseText.setText("没有前一页，"+"page="+page);
            }else {
                page=page-1;
                sendRequestWithOkHttp(page);

            }
        }
        if (v.getId() == R.id.but_n) {
            if (page>=4365){
                mTv_responseText.setText("没有了,"+"page="+page);
            }else {
                page=page+1;
                sendRequestWithOkHttp(page);

            }


        }
    }

    private void sendRequestWithOkHttp(int page) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 创建一个OkHttpClient的实例
                    OkHttpClient client = new OkHttpClient();
                    // 如果要发送一条HTTP请求，就需要创建一个Request对象
                    // 可在最终的build()方法之前连缀很多其他方法来丰富这个Request对象

                    Request request = new Request.Builder()
                            .url("http://tuwenhao.xyz:5000/?page="+page+"&limit=1")
                            .build();
                    // 调用OkHttpClient的newCall()方法来创建一个Call对象，并调用execute()方法来发送请求并获取服务器的返回数据
                    Response response = client.newCall(request).execute();
                    // 其中Response对象就是服务器返回的数据，将数据转换成字符串
                    String responseData = response.body().string();
                    // 将获取到的字符串传入showResponse()方法中进行UI显示
                    show(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // 返回主线程并执行更改UI操作
    private void show(final String data) {
        runOnUiThread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                try {
                    JSONObject jsonObject1 = new JSONObject(data);
                    //Log.e("Json", json);
                    JSONArray jsonArray = jsonObject1.getJSONArray("data");
                    code=jsonObject1.getString("code");
                    msg=jsonObject1.getString("msg");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        //取出name
                        nid = jsonObject.getString("nid");
                        id = jsonObject.getString("id");
                        classq = jsonObject.getString("class");
                        jishu = jsonObject.getString("jishu");
                        img_url = jsonObject.getString("img_url");
                        year = jsonObject.getString("year");
                        name = jsonObject.getString("name");
                        text = jsonObject.getString("text");
                        Log.d("Json",nid);
                        Log.d("Json",id);
                        Log.d("Json",img_url);
                        Log.d("Json",year);
                        Log.d("Json",name);
                        Log.d("Json",code);
                        Log.d("Json",msg);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                    mTv_responseText.setText("信息："+msg+",page="+page);
                    text_nid.setText(nid);
                    text_id.setText(id);
                    text_classq.setText("类别："+classq);
                    text_jishu.setText("集数："+jishu);
                    text_img_url.setText("图片链接："+img_url);
                    text_year.setText("年份："+year);
                    text_name.setText(name);
                    text_text.setText("简介："+text);
                    getImageBitmap(img_url);


            }
        });
    }
    //加载图片
    public void getImageBitmap(String url) {
        Glide.with(this).load(url).into(image_cover);
    }



}

