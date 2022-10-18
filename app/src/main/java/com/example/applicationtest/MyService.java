package com.example.applicationtest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.SeekBar;

import java.io.IOException;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private String url;
    private SeekBar seekBar;


    public MyService() {
        mediaPlayer=new MediaPlayer();
    }

    public void getseekBar(SeekBar seekBar){
        this.seekBar=seekBar;
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        url=(String) intent.getExtras().get("url");
        Log.d("geturl",url);
//        mediaPlayer=new MediaPlayer();
//        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.flower);
        try {
            mediaPlayer.setDataSource("https://cdn.unrun.top/blog/music/"+url);
            Log.d("mm","https://cdn.unrun.top/blog/music/"+url);
            //3 准备播放
            mediaPlayer.prepareAsync();
//            3.1 设置一个准备完成的监听
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    // 4 开始播放
                    mediaPlayer.start();
                    int time=mediaPlayer.getDuration();
                    //设置最大值为音乐播放的时间
//                    if (time!=null){
//                        seekBar.setMax(time);
//                        new MyThread().start();
//                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("m","stop");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
//         TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }
    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            while(seekBar.getProgress()<seekBar.getMax()){
                //获得音乐当前的播放位置
                int currentPosition=mediaPlayer.getCurrentPosition();
                seekBar.setProgress(currentPosition);
            }
        }
    }



}