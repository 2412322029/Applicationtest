package com.example.applicationtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText("" + position);//转字符串
        holder.textView2.setText(list.get(position));
        holder.imageView_item1.setImageResource(addimg(position));
//        holder.linearLayout_item1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(itemview.getContext(), position + "号:" + list.get(position), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
//                intent.putExtra("msg","position:"+position+"\n"+list.get(position));
//                context.startActivity(intent);
//                //onSwiped(position);
//            }
//        });
        holder.linearLayout_item1.setOnTouchListener(new View.OnTouchListener() {
            private int X;
            private int lastX;
            private int Y;
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN://当屏幕检测到第一个触点按下之后就会触发到这个事件。
                        lastX = (int) event.getRawX();
                        Y = (int) event.getRawY();
                        X = (int) event.getRawX();
                        break;
                    case MotionEvent.ACTION_UP://当触点松开时被触发。
                        if (Math.abs((int) event.getRawX() - X)<2){//单击，点击坐标没发生变化
                            Toast.makeText(itemview.getContext(), position + "号:" + list.get(position), Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(holder.itemView.getContext(), MainActivity.class);
//                            intent.putExtra("msg","position:"+position+"\n"+list.get(position));
//                            context.startActivity(intent);
                        }
                        if(Math.abs(((int) event.getRawX() - X))<200){
                            holder.linearLayout_item1.setLeft(0);
                        }else{
                            onSwiped(position);
                            holder.linearLayout_item1.setLeft(0);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) event.getRawX() - lastX;
                        int left = view.getLeft() + dx;
                        holder.linearLayout_item1.setLeft(left);
                        lastX = (int) event.getRawX();
                        break;
                }
                return true;
            }
        });
    }
    //  删除数据
    @SuppressLint("NotifyDataSetChanged")
    public void onSwiped(int p) {
        list.remove(p);
        notifyItemRemoved(p);
        notifyDataSetChanged();
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
            linearLayout_item1 = itemView.findViewById(R.id.linearLayout_forresult);


        }
    }

}
