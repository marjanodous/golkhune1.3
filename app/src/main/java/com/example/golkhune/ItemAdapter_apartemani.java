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

public class ItemAdapter_apartemani extends RecyclerView.Adapter<ItemAdapter_apartemani.MyViewHolder> {
    List<Item>itemList_apartemani;
    Context mContext_apartemani;
    public static boolean flag_apartemani=false;
    public ItemAdapter_apartemani(List<Item>itemList_apartemani, Context mContext_apartemani){
        this.itemList_apartemani = itemList_apartemani;
        this.mContext_apartemani = mContext_apartemani;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu,parent,false);
        return new MyViewHolder(aView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar_apartemani.setImageResource(itemList_apartemani.get(position).getuAvatar());
        holder.aName_apartemani.setText(itemList_apartemani.get(position).getuName());
        holder.aMessage_apartemani.setText(itemList_apartemani.get(position).getuMessage());
        holder.aAvatar_apartemani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_apartemani=true;
                Intent intent  = new Intent(mContext_apartemani, tozihat.class);
                intent.putExtra("title_flower_apartemani",itemList_apartemani.get(position).getuName());
                intent.putExtra("image_apartemani",itemList_apartemani.get(position).getuAvatar());
                intent.putExtra("water_apartemani",itemList_apartemani.get(position).getuWater());
                intent.putExtra("light_apartemani",itemList_apartemani.get(position).getuLight());
                intent.putExtra("temp_apartemani",itemList_apartemani.get(position).getuTemperature());
                intent.putExtra("information_apartemani",itemList_apartemani.get(position).getuMessage());
                mContext_apartemani.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList_apartemani.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar_apartemani;
        public TextView aName_apartemani;
        public TextView aMessage_apartemani;



        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar_apartemani = itemView.findViewById(R.id.img_avatar);
            aName_apartemani = itemView.findViewById(R.id.txt_name);
            aMessage_apartemani = itemView.findViewById(R.id.txt_message);

        }
    }

}