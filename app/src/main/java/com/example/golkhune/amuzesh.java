package com.example.golkhune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class amuzesh extends AppCompatActivity {
RelativeLayout lnr_film,lnr_afat,lnr_taviz,lnr_alafharz,lnr_zardshodan,lnr_abdadan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amuzesh);
    lnr_film=findViewById(R.id.lnr_film);
    lnr_afat=findViewById(R.id.lnr_afat);
    lnr_taviz=findViewById(R.id.lnr_taviz);
    lnr_alafharz=findViewById(R.id.lnr_alafharz);
    lnr_zardshodan=findViewById(R.id.lnr_zardshodan);
    lnr_abdadan=findViewById(R.id.lnr_abdadan);
    lnr_film.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(amuzesh.this,film.class));
        }
    });
    lnr_afat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(amuzesh.this, az_bein_bordan_afat.class));
        }
    });
        lnr_taviz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(amuzesh.this, taviz_khak.class));
            }
        });
        lnr_alafharz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(amuzesh.this, alaf_harz.class));
            }
        });
        lnr_zardshodan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(amuzesh.this, zard_shodan.class));
            }
        });
        lnr_abdadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(amuzesh.this, ab_dadan.class));
            }
        });

    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
