package com.example.golkhune.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.golkhune.Item;
import com.example.golkhune.R;
import com.example.golkhune.*;

import java.util.ArrayList;

public class AdapterSearch extends ArrayAdapter {

    public int resourceId;
    public Context context;
    public ArrayList<Item> data;
    public static boolean flag_search=false;
    /*create object for xml*/
    TextView txtName;


    public AdapterSearch(int resourceId, Context context, ArrayList<Item> data) {
        super(context, resourceId, data);
        this.resourceId = resourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(this.resourceId, null);

        /* Get object from xml file*/
        txtName = view.findViewById(R.id.txt_search);

        /*set value to model array*/
        Item model = new Item();
        model =data.get(position);
        txtName.setText(model.getuName());

        /*1.click to show tozihat */
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = data.get(position).getuName();
                if(title.contains("فیلم آموزشی")){
                    Intent intent  = new Intent(context, film.class);
                    context.startActivity(intent);
                }
                else if(title.contains("روش از بین بردن آفت گیاهان")){
                    Intent intent  = new Intent(context, az_bein_bordan_afat.class);
                    context.startActivity(intent);
                }
                else if(title.contains("روش تعویض خاک گلدان")){
                    Intent intent  = new Intent(context, taviz_khak.class);
                    context.startActivity(intent);
                }
                else if(title.contains("از بین بردن علف هرز")){
                    Intent intent  = new Intent(context, alaf_harz.class);
                    context.startActivity(intent);
                }
                else if(title.contains("زرد شدن برگ درخت ها")){
                    Intent intent  = new Intent(context, zard_shodan.class);
                    context.startActivity(intent);
                }
                else if(title.contains("آب دادن به گل و گیاه")){
                    Intent intent  = new Intent(context, ab_dadan.class);
                    context.startActivity(intent);
                }
                else {
                    flag_search=true;
                    Intent intent  = new Intent(context, tozihat.class);
                    intent.putExtra("title_search",data.get(position).getuName());
                    intent.putExtra("img_search",data.get(position).getuAvatar());
                    intent.putExtra("water_search",data.get(position).getuWater());
                    intent.putExtra("light_search",data.get(position).getuLight());
                    intent.putExtra("temperature_search",data.get(position).getuTemperature());
                    intent.putExtra("message_search",data.get(position).getuMessage());
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }
}