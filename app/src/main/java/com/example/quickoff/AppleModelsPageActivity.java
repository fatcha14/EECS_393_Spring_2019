package com.example.quickoff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppleModelsPageActivity extends AppCompatActivity {

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

        models.add("iPhone XS");
        models.add("iPhone XS Max");
        models.add("iPhone XR");

        List<String> iphone_xs = new ArrayList<>();
        iphone_xs.add("64GB");
        iphone_xs.add("256GB");
        iphone_xs.add("512GB");

        List<String> iphone_xs_max = new ArrayList<>();
        iphone_xs_max.add("64GB");
        iphone_xs_max.add("256GB");
        iphone_xs_max.add("512GB");


        List<String> iphone_xr = new ArrayList<>();
        iphone_xr.add("64GB");
        iphone_xr.add("128GB");
        iphone_xr.add("256GB");


        listHash.put(models.get(0),iphone_xs);
        listHash.put(models.get(1),iphone_xs_max);
        listHash.put(models.get(2),iphone_xr);
    }
}
