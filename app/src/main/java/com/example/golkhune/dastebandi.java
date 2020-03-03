package com.example.golkhune;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * A simple {@link Fragment} subclass.
 */
public class dastebandi extends Fragment {
    RelativeLayout lnr_apartemani,lnr_biruni,lnr_amuzesh;
    public static String Transaction_type;
    public static boolean flag_apartmani,flag_biruni, flag_amuzesh = false;


    public dastebandi() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dastebandi, container, false);
        lnr_apartemani=rootView.findViewById(R.id.lnr_apartemani);
        lnr_biruni=rootView.findViewById(R.id.lnr_biruni);
        lnr_amuzesh=rootView.findViewById(R.id.lnr_amuzesh);

        lnr_apartemani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getActivity(),apartemani.class));
            }
        });
        lnr_biruni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),biruni.class));
            }
        });
        lnr_amuzesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),amuzesh.class));
            }
        });
        return rootView;
    }
    //======================change font===============================
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }

}







