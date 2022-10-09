package com.example.applicationtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> {
    private View itemview;
    private Context context;

    private List<String> list;


    public int addimg(int i) {
        if (i % 4 == 0) {
            return R.drawable.num_a;
        } else if (i % 4 - 1 == 0) {
            return R.drawable.num_b;
        } else if (i % 4 - 2 == 0) {
            return R.drawable.num_c;
        } else if (i % 4 - 3 == 0) {
            return R.drawable.num_d;
        } else {
            return R.drawable.ic___fx;
        }

    }

    public Adapter(Context context) {

        this.context = context;

    }

    public void list(List<String> list) {
        this.list = list;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemview = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
        Myholder holder;

        holder = new Myholder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText("" + position);//转字符串
        holder.textView2.setText(list.get(position));
        holder.imageView_item1.setImageResource(addimg(position));
        holder.linearLayout_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(itemview.getContext(), position + "号:" + list.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra("msg","position:"+position+"\n"+list.get(position));
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Myholder extends RecyclerView.ViewHolder {

        private TextView textView1, textView2;
        private ImageView imageView_item1;
        private LinearLayout linearLayout_item1;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView_item1);
            textView2 = itemView.findViewById(R.id.textView_item2);
            imageView_item1 = itemView.findViewById(R.id.imageView_item1);
            linearLayout_item1 = itemView.findViewById(R.id.linearLayout_item1);


        }
    }

}
