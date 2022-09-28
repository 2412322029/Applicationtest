package com.example.applicationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;


public class myadapter extends RecyclerView.Adapter<myadapter.Myholder> {
    private  View view;
    private Context context;
    private List<String> list;

    public myadapter(Context context, List<String> list) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item,parent);
        Myholder holder;
        holder=new Myholder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class  Myholder extends RecyclerView.ViewHolder{
        private TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView_item1);

        }
    }
}
