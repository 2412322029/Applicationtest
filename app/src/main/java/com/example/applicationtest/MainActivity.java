package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1, imageView2, imageView3, imageView4;
    private TextView textView1, textView2, textView3, textView4;
    private Fragment fragment1, fragment2, fragment3, fragment4;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBar statusBar = new StatusBar(MainActivity.this);
        //设置颜色为半透明
        statusBar.setStatusBarColor(R.color.translucent);
        //设置颜色为透明
        statusBar.setStatusBarColor(R.color.transparent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setNavigationBarColor(Color.TRANSPARENT);

        }


        setContentView(R.layout.activity_main);


        event_init();
        fragment_init();


    }

    private void fragment_init() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        Log.d("ffff", "init");

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .add(R.id.frameLayout, fragment1)
                .add(R.id.frameLayout, fragment2)
                .add(R.id.frameLayout, fragment3)
                .add(R.id.frameLayout, fragment4)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();

    }

    private void event_init() {
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        //四个svg
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        //四个文字
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView1.setImageResource(R.drawable.ic___wx_this);
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
            default:
                break;
        }
    }

    private void hideall(FragmentTransaction transaction) {
        transaction.hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        Log.d("ffff", "hide");
    }

    private void rebu() {
        imageView1.setImageResource(R.drawable.ic___wx);
        textView1.setTextColor(0xFF000000);
        imageView2.setImageResource(R.drawable.ic___txl);
        textView2.setTextColor(0xFF000000);
        imageView3.setImageResource(R.drawable.ic___fx);
        textView3.setTextColor(0xFF000000);
        imageView4.setImageResource(R.drawable.ic___me);
        textView4.setTextColor(0xFF000000);
    }

    private void select(int i) {
        TextView textView_top = findViewById(R.id.textView_top);

        FragmentTransaction transaction = manager.beginTransaction();
        hideall(transaction);
        switch (i) {
            case 1:
                transaction.show(fragment1);
                textView_top.setText("微信");
                rebu();
                imageView1.setImageResource(R.drawable.ic___wx_this);
                textView1.setTextColor(0xFF07C060);
                Log.d("show", "case1")
                ;
                break;
            case 2:
                transaction.show(fragment2);
                textView_top.setText("通讯录");
                rebu();
                imageView2.setImageResource(R.drawable.ic___txl_this);
                textView2.setTextColor(0xFF07C060);
                Log.d("show", "case2")
                ;
                break;
            case 3:
                transaction.show(fragment3);
                textView_top.setText("发现");
                rebu();
                imageView3.setImageResource(R.drawable.ic___fx_this);
                textView3.setTextColor(0xFF07C060);
                Log.d("show", "case3")
                ;
                break;
            case 4:
                transaction.show(fragment4);
                textView_top.setText("我的");
                rebu();
                imageView4.setImageResource(R.drawable.ic___me_this);
                textView4.setTextColor(0xFF07C060);
                ;
                break;
            default:
                break;
        }
        transaction.commit();
    }


    public static class StatusBar {
        private Activity activity;

        //初始化activity
        public StatusBar(Activity activity) {
            this.activity = activity;
        }

        //将状态栏设置为传入的color
        public void setStatusBarColor(int color) {
            if (Build.VERSION.SDK_INT >= 21) {
                View view = activity.getWindow().getDecorView();
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                activity.getWindow().setStatusBarColor(activity.getResources().getColor(color));

            }
        }


    }


}