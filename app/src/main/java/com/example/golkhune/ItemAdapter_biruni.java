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

public class ItemAdapter_biruni extends RecyclerView.Adapter<ItemAdapter_biruni.MyViewHolder> {
    List<Item>itemList_biruni;
    Context mContext_biruni;
    public static boolean flag_biruni=false;
    public ItemAdapter_biruni(List<Item>itemList_biruni, Context mContext_biruni){
        this.itemList_biruni = itemList_biruni;
        this.mContext_biruni = mContext_biruni;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu,parent,false);
        return new MyViewHolder(aView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar_biruni.setImageResource(itemList_biruni.get(position).getuAvatar());
        holder.aName_biruni.setText(itemList_biruni.get(position).getuName());
        holder.aMessage_biruni.setText(itemList_biruni.get(position).getuMessage());
        holder.aAvatar_biruni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_biruni=true;
                Intent intent  = new Intent(mContext_biruni, tozihat.class);
                intent.putExtra("title_flower_biruni",itemList_biruni.get(position).getuName());
                intent.putExtra("image_biruni",itemList_biruni.get(position).getuAvatar());
                intent.putExtra("water_biruni",itemList_biruni.get(position).getuWater());
                intent.putExtra("light_biruni",itemList_biruni.get(position).getuLight());
                intent.putExtra("temp_biruni",itemList_biruni.get(position).getuTemperature());
                intent.putExtra("information_biruni",itemList_biruni.get(position).getuMessage());
                mContext_biruni.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList_biruni.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar_biruni;
        public TextView aName_biruni;
        public TextView aMessage_biruni;



        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar_biruni = itemView.findViewById(R.id.img_avatar);
            aName_biruni= itemView.findViewById(R.id.txt_name);
            aMessage_biruni= itemView.findViewById(R.id.txt_message);

        }
    }

}