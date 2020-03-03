package com.example.golkhune;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.MyViewHolder> {
    List<Item>itemList2;
    Context mContext2;
    public static boolean flag_behtarin=false;
    public ItemAdapter2(List<Item>itemList2, Context mContext2){
        this.itemList2 = itemList2;
        this.mContext2 = mContext2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahbubtarin,parent,false);
        return new MyViewHolder(aView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar2.setImageResource(itemList2.get(position).getuAvatar());
        holder.aName2.setText(itemList2.get(position).getuName());
        holder.aMessage2.setText(itemList2.get(position).getuMessage());
        holder.aAvatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_behtarin=true;
                Intent intent  = new Intent(mContext2, tozihat.class);
                intent.putExtra("title_flower_behtarin",itemList2.get(position).getuName());
                intent.putExtra("image_behtarin",itemList2.get(position).getuAvatar());
                intent.putExtra("water_behtarin",itemList2.get(position).getuWater());
                intent.putExtra("light_behtarin",itemList2.get(position).getuLight());
                intent.putExtra("temp_behtarin",itemList2.get(position).getuTemperature());
                intent.putExtra("information_behtarin",itemList2.get(position).getuMessage());
                mContext2.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar2;
        public TextView aName2;
        public TextView aMessage2;



        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar2 = itemView.findViewById(R.id.img_avatar);
            aName2 = itemView.findViewById(R.id.txt_name);
            aMessage2 = itemView.findViewById(R.id.txt_message);

        }
    }

}