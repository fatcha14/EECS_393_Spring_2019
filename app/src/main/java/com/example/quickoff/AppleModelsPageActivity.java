package com.example.quickoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    String[] apple_models = {"iPhone XS", "iPhone XS Max", "iPhone XR"};
    String[] apple_storage = {"64GB", "128GB", "256GB", "512GB"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_models_page);

        listView = (ExpandableListView)findViewById(R.id.apple_models_list);
        initData();
        listAdapter = new MyExpandableListAdapter(this, models,listHash);
        listView.setAdapter(listAdapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                                        int groupPosition, int childPosition, long id) {
                if (groupPosition == 0 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    startActivity(intent);
                }
                if (groupPosition == 0 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void initData() {
        models = new ArrayList<>();
        listHash = new HashMap<>();

        models.add(apple_models[0]);
        models.add(apple_models[1]);
        models.add(apple_models[2]);

        List<String> iphone_xs = new ArrayList<>();
        iphone_xs.add(apple_storage[0]);
        iphone_xs.add(apple_storage[2]);
        iphone_xs.add(apple_storage[3]);

        List<String> iphone_xs_max = new ArrayList<>();
        iphone_xs_max.add(apple_storage[0]);
        iphone_xs_max.add(apple_storage[2]);
        iphone_xs_max.add(apple_storage[3]);


        List<String> iphone_xr = new ArrayList<>();
        iphone_xr.add(apple_storage[0]);
        iphone_xr.add(apple_storage[1]);
        iphone_xr.add(apple_storage[2]);


        listHash.put(models.get(0),iphone_xs);
        listHash.put(models.get(1),iphone_xs_max);
        listHash.put(models.get(2),iphone_xr);
    }
}
