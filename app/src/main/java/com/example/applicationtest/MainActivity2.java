package com.example.applicationtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MainActivity2 extends AppCompatActivity {

    private MyService musicserver;
    private Button btb_start;
    private SeekBar seekBar;
    private String position;
    private String url;
    public Context context;
    private Intent intent1;
    private Intent intent2;
    private MyService.Mybinder mybinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("twh","oncreate");
        Intent intent=getIntent();
        position=intent.getStringExtra("position");
        String name=intent.getStringExtra("namelist");
        String artist=intent.getStringExtra("artistlist");
        String cover=intent.getStringExtra("coverlist");
        url=intent.getStringExtra("urllist");

        TextView textView_main2_01=findViewById(R.id.textView_main2_01);
        textView_main2_01.setText(position+"\n"+name+"\n"+artist+"\n"+cover);

        ImageView imageView_music=findViewById(R.id.imageView_music);
        context = this;
        Glide.with(context).load("https://cdn.unrun.top/blog/music/" +cover).into(imageView_music);

        play();

        intent2 = new Intent(this,MyService.class);
        Button button_bond=findViewById(R.id.button_bond);
        Button button_unbond=findViewById(R.id.button_unbond);

        ServiceConnection connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mybinder =(MyService.Mybinder)iBinder;
                mybinder.myplay();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                mybinder=null;
            }
        };
        button_bond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent2,connection,Context.BIND_AUTO_CREATE);
            }
        });
        button_unbond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(connection);
            }
        });

    }

    private void play( ) {
        musicserver=new MyService();
        // TODO 删下一行
        url="https://cdn.unrun.top/blog/music/1.mp3";

        Log.d("xxxx",url);
        btb_start = findViewById(R.id.button_start);
        seekBar=findViewById(R.id.seekBar);
        musicserver.getseekBar(seekBar);

        final int[] flag = {0};

        intent1 = new Intent(this,MyService.class);

        btb_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (flag[0] ==0){
                    intent1.putExtra("url",url);
                    startService(intent1);
                    btb_start.setText("暂停");
                    flag[0]++;
                }else if(flag[0] ==1){
                    stopService(intent1);
                    btb_start.setText("开始");
                    flag[0]--;
                }


            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("twh","onStart");
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
        stopService(intent1);
        Log.d("twh","onDestroy");
    }
}