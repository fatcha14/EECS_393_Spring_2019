package com.example.quickoff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SamsungModelsPageActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> models;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_models_page);

        listView = (ExpandableListView)findViewById(R.id.apple_models_list);
        initData();
        listAdapter = new MyExpandableListAdapter(this, models,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        models = new ArrayList<>();
        listHash = new HashMap<>();

        models.add("S10");
        models.add("S10+");
        models.add("S10e");

        List<String> s10 = new ArrayList<>();
        s10.add("128GB");
        s10.add("256GB");
        s10.add("512GB");

        List<String> S10_Plus = new ArrayList<>();
        S10_Plus.add("128GB");
        S10_Plus.add("256GB");
        S10_Plus.add("512GB");
        S10_Plus.add("1TB");


        List<String> s10_e = new ArrayList<>();
        s10_e.add("64GB");
        s10_e.add("128GB");
        s10_e.add("256GB");


        listHash.put(models.get(0),s10);
        listHash.put(models.get(1),S10_Plus);
        listHash.put(models.get(2),s10_e);
    }
}