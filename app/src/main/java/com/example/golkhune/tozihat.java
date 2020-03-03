package com.example.golkhune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.golkhune.adapter.AdapterSearch;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class tozihat extends AppCompatActivity {
    ImageView img_back,img_tozihat;
    TextView txt_name_flower,txt_water,txt_temp,txt_information,txt_light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tozihat);
        //for full screen page
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //for find recycler
        txt_information=findViewById(R.id.txt_information);
        txt_temp= findViewById(R.id.txt_temp);
        txt_water = findViewById(R.id.txt_water);
        txt_name_flower=findViewById(R.id.txt_name_flower);
        img_back=findViewById(R.id.img_back);
        img_tozihat=findViewById(R.id.img_tozihat);
        txt_light=findViewById(R.id.txt_light);

        //////load from recycler_new
        if (ItemAdapter_new.flag_new == true) {
            Bundle bundle = getIntent().getExtras();
            txt_name_flower.setText(bundle.getString("title_flower_new"));
            txt_information.setText(bundle.getString("information_new"));
            txt_temp.setText(bundle.getString("temp_new"));
            txt_light.setText(bundle.getString("light_new"));
            txt_water.setText(bundle.getString("water_new"));
            img_tozihat.setImageResource(bundle.getInt("image_new"));
        }
        else if (ItemAdapter2.flag_behtarin == true) {
            Bundle bundle = getIntent().getExtras();
            txt_name_flower.setText(bundle.getString("title_flower_behtarin"));
            txt_information.setText(bundle.getString("information_behtarin"));
            txt_temp.setText(bundle.getString("temp_behtarin"));
            txt_light.setText(bundle.getString("light_behtarin"));
            txt_water.setText(bundle.getString("water_behtarin"));
            img_tozihat.setImageResource(bundle.getInt("image_behtarin"));
        }
        else if (ItemAdapter_apartemani.flag_apartemani == true) {
            Bundle bundle = getIntent().getExtras();
            txt_name_flower.setText(bundle.getString("title_flower_apartemani"));
            txt_information.setText(bundle.getString("information_apartemani"));
            txt_temp.setText(bundle.getString("temp_apartemani"));
            txt_light.setText(bundle.getString("light_apartemani"));
            txt_water.setText(bundle.getString("water_apartemani"));
            img_tozihat.setImageResource(bundle.getInt("image_apartemani"));
        }
        else if (ItemAdapter_biruni.flag_biruni == true) {
            Bundle bundle = getIntent().getExtras();
            txt_name_flower.setText(bundle.getString("title_flower_biruni"));
            txt_information.setText(bundle.getString("information_biruni"));
            txt_temp.setText(bundle.getString("temp_biruni"));
            txt_light.setText(bundle.getString("light_biruni"));
            txt_water.setText(bundle.getString("water_biruni"));
            img_tozihat.setImageResource(bundle.getInt("image_biruni"));
        }
        else if (AdapterSearch.flag_search == true) {
            Bundle bundle = getIntent().getExtras();
            txt_name_flower.setText(bundle.getString("title_search"));
            txt_information.setText(bundle.getString("message_search"));
            txt_temp.setText(bundle.getString("temperature_search"));
            txt_light.setText(bundle.getString("light_search"));
            txt_water.setText(bundle.getString("water_search"));
            img_tozihat.setImageResource(bundle.getInt("img_search"));
        }
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemAdapter_new.flag_new =false;
                ItemAdapter2.flag_behtarin =false;
                ItemAdapter_apartemani.flag_apartemani =false;
                ItemAdapter_biruni.flag_biruni = false;
                AdapterSearch.flag_search = false;
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        ItemAdapter_new.flag_new =false;
        ItemAdapter2.flag_behtarin =false;
        ItemAdapter_apartemani.flag_apartemani =false;
        ItemAdapter_biruni.flag_biruni = false;
        AdapterSearch.flag_search = false;
        super.onBackPressed();
    }

    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
