package com.example.applicationtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;


public class Fragment2 extends Fragment {

    private RecyclerView recyclerView;
    private Context context;
    private FloatingActionButton fab;
    private Adapter myadapter;
    private List<String> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.tab02, container, false);

        recyclerView = view.findViewById(R.id.recyclerView1);
        listdata();
        Viewinit();
        return view;



    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onStart() {
        super.onStart();
        fab=getActivity().findViewById(R.id.fab);
        ConstraintLayout constraintlayout_none=getActivity().findViewById(R.id.constraintlayout_none);
        EditText text_add=getActivity().findViewById(R.id.text_add);
        Button button_cl=getActivity().findViewById(R.id.button_cl);
        Button button_ok=getActivity().findViewById(R.id.button_ok);
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);   ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintlayout_none.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                imm.showSoftInput(text_add, 0);
                text_add.setText("");
                button_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s=text_add.getText().toString();
                        constraintlayout_none.setVisibility(View.GONE);
                        list.add(s);
                        Log.d("add","+1");
                        imm.hideSoftInputFromWindow(text_add.getWindowToken(), 0);
                        myadapter.notifyDataSetChanged();
                        recyclerView.scrollToPosition(myadapter.getItemCount() - 1);
                        Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show();
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });
                button_cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        constraintlayout_none.setVisibility(View.GONE);
                        Toast.makeText(context, "取消添加", Toast.LENGTH_SHORT).show();
                        recyclerView.setVisibility(View.VISIBLE);
                        imm.hideSoftInputFromWindow(text_add.getWindowToken(), 0);
                    }
                });
                //list.add("111111");
                //Log.d("add",list.toString());


            }
        });


    }

    private void Viewinit() {
        context = this.getActivity();
        //fullview=getView();
        myadapter = new Adapter(context);
        //设置LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myadapter);
        myadapter.list(list);

    }

    private void listdata() {
        list.add("明媚的阳光和明媚的少女······是不是很相衬呢？");
        list.add("别动哦，借你的眼睛照照镜子。是不是觉得很怀念？");
        list.add("我的眼睛漂亮吗？这可不是美瞳哦，是美少女的魔法。");
        list.add("我也会阿波尼亚的读心术，比如，你在想我，对不对？");
        list.add("愿时光永驻此刻，伊甸的歌很美吧，就像是我们的心声。");
        list.add("悲剧并非终结，而是希望的起始，你会如此坚信的，对吧！");
        list.add("芽衣是和我一样完美的女孩，现在的她一定什么都做得到。");
        list.add("想听甜甜的故事吗？比如，科斯魔和黛丝多比娅的青春往事。");
        list.add("今天的任务都完成了，真棒，夸夸你哦。");
        list.add("我还有好多好多话想对你说，就这样一直继续下去，好吗？");
        list.add("你已知晓了我的过去，作为交换，我想见证你的未来。");
        list.add("故事总有结局，但它留下的记忆和感情会一直延续，不是吗？");
        list.add("你看，我早就说过，千劫是个很温柔的人，现在你也能明白了吧。");
        list.add("这里有好多和我一样的律者呀！我做到了，对吗？");
        list.add("哦？你刚刚一直在盯着我看，对不对？");
        list.add("你该休息了，别担心，明天我也会在这里等你的。");

    }


}