package com.example.applicationtest.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.applicationtest.MainActivity2;
import com.example.applicationtest.R;

import java.util.ArrayList;
import java.util.List;

public class musicAdapter extends RecyclerView.Adapter<musicAdapter.Myholder> {
    private View itemview;
    private Context context;

    private List<String> namelist;
    private List<String> artistlist;
    private List<String> urllist;
    private List<String> coverlist;


    public musicAdapter(Context context) {

        this.context = context;
    }

    public void list(List<String> namelist,List<String> artistlist,List<String> urllist,List<String> coverlist) {
        this.namelist=  namelist;
        this.artistlist= artistlist;
        this.urllist= urllist;
        this.coverlist= coverlist;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemview = LayoutInflater.from(context).inflate(R.layout.musicitem, parent, false);
        Myholder holder;

        holder = new Myholder(itemview);
        return holder;
    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.music_name.setText(namelist.get(position));//转字符串
        holder.detail.setText(artistlist.get(position));
        Glide.with(context).load("https://cdn.unrun.top/blog/music/" + coverlist.get(position)).into(holder.imageView_avarat);
        holder.linearLayout_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(itemview.getContext(), position + "号:" + list.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra("position",""+position);
                intent.putExtra("namelist",namelist.get(position));
                intent.putExtra("artistlist",artistlist.get(position));
                intent.putExtra("coverlist",coverlist.get(position));
                intent.putExtra("urllist",urllist.get(position));
                context.startActivity(intent);
                //onSwiped(position);
            }
        });

    }



    @Override
    public int getItemCount() {
        return namelist.size();
//        return 10;
    }

    public static class Myholder extends RecyclerView.ViewHolder {

        private TextView music_name, detail;
        private ImageView imageView_avarat;
        private LinearLayout linearLayout_music;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            music_name = itemView.findViewById(R.id.music_name);
            detail = itemView.findViewById(R.id.detail);
            imageView_avarat = itemView.findViewById(R.id.imageView_avarat);
            linearLayout_music = itemView.findViewById(R.id.linearLayout_music);


        }
    }

}
