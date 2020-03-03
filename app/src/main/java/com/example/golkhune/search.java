package com.example.golkhune;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.golkhune.adapter.AdapterSearch;
import com.example.golkhune.model.FlowersSearch;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * A simple {@link Fragment} subclass.
 */
public class search extends Fragment {

    /*create object for xml*/
    ArrayList<Item> listDefault, listSearch;
    ListView listView;
    FlowersSearch flowersSearch = new FlowersSearch();
    EditText edtSearch;
    TextView txtResult;
    ImageView imgClear;
    AdapterSearch adapterSearch;

    public search() {
    }

    public static search newInstance() {
        Bundle args = new Bundle();
        search fragment = new search();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_search, container, false);
        View rooView = inflater.inflate(R.layout.fragment_search, null);
        listView = rooView.findViewById(R.id.listView_search);
        edtSearch = rooView.findViewById(R.id.edt_name_search);
        imgClear = rooView.findViewById(R.id.imgsearch_clear);
        txtResult = rooView.findViewById(R.id.result_search);

        /*calling method defult to listdefault*/
        setdefualt();


        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSearch.setText("");
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*when text the length > 3 char*/
                String text = edtSearch.getText().toString().trim();
                if (text.length() >= 2) {
                    /* calling method set item list equal with user typing*/
                    serchArray(text);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = edtSearch.getText().toString().trim();
                if (text.length() <= 0) {
                    txtResult.setText("نتیجه جستجو");
                    listSearch = new ArrayList<>();
                    setItemListSearch();
                }
            }
        });
        return rooView;
    }

    /* method add item to list defult montakhab */
    public void setdefualt() {
        listDefault = new ArrayList<>();
        listDefault = flowersSearch.setList();
//        adapterSearch=new AdapterSearch(R.layout.searchitem,getContext(), listDefault);
//        listView.setAdapter(adapterSearch);
    }
    /* 8.method from checked name is equal whit list item defult*/
    public void serchArray(String name) {
        listSearch = new ArrayList<>();
        String sname = name;
        boolean flag=false;
        for (Item item : listDefault) {
            int img =item.getuAvatar();
            String strlist = item.getuName();
            String water = item.getuWater();
            String light = item.getuLight();
            String temperature = item.getuTemperature();
            String message = item.getuMessage();
            if (strlist.contains(sname)) {
                flag=true;
                /*add equal item to list ActivitySearch*/
                listSearch.add(new Item(img,strlist,water,light,temperature,message));
                /*calling method to show list ActivitySearch*/
                setItemListSearch();
                txtResult.setText("نتیجه جستجو");
            } else if(flag==false){
                /*set empty item to listsearch*/
                listSearch = new ArrayList<>();
                setItemListSearch();
                txtResult.setText("موردی یافت نشد");
            }

        }

    }
    /*7.method show item to list*/
    public void setItemListSearch() {
        adapterSearch = new AdapterSearch( R.layout.searchitem,getContext() ,listSearch);
        listView.setAdapter(adapterSearch);
    }
    //======================change font===============================
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }
}
