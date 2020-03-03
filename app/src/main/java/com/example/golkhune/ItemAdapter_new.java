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

public class ItemAdapter_new extends RecyclerView.Adapter<ItemAdapter_new.MyViewHolder> {
    List<Item>itemList;
    Context mContext;
    public static boolean flag_new=false;
    public ItemAdapter_new(List<Item>itemList, Context mContext){
        this.itemList = itemList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_new,parent,false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar.setImageResource(itemList.get(position).getuAvatar());
        holder.aName.setText(itemList.get(position).getuName());
        holder.aMessage.setText(itemList.get(position).getuMessage());
        holder.aAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            flag_new=true;
                Intent intent  = new Intent(mContext, tozihat.class);
                intent.putExtra("title_flower_new",itemList.get(position).getuName());
                intent.putExtra("image_new",itemList.get(position).getuAvatar());
                intent.putExtra("water_new",itemList.get(position).getuWater());
                intent.putExtra("light_new",itemList.get(position).getuLight());
                intent.putExtra("temp_new",itemList.get(position).getuTemperature());
                intent.putExtra("information_new",itemList.get(position).getuMessage());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar;
        public TextView aName;
        public TextView aMessage;


        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar = itemView.findViewById(R.id.img_avatar);
            aName = itemView.findViewById(R.id.txt_name);
            aMessage = itemView.findViewById(R.id.txt_message);


        }
    }

}