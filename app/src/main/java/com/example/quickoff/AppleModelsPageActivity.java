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
    String company = "Apple";
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
                // case for iphone xs 64GB
                if (groupPosition == 0 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[0], apple_storage[0], company};
                    intent.putExtra("iPhone XS 64GB", message);
                    startActivity(intent);
                }
                // case for iphone xs 256GB
                if (groupPosition == 0 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[0], apple_storage[2]};
                    intent.putExtra("iPhone XS 256GB", message);
                    startActivity(intent);
                }
                // case for iphone xs 512GB
                if (groupPosition == 0 && childPosition == 2) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[0], apple_storage[3]};
                    intent.putExtra("iPhone XS 512GB", message);
                    startActivity(intent);
                }
                // case for iphone xs max 64GB
                if (groupPosition == 1 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[1], apple_storage[0]};
                    intent.putExtra("iPhone XS MAX 64GB", message);
                    startActivity(intent);
                }
                // case for iphone xs max 256GB
                if (groupPosition == 1 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[1], apple_storage[2]};
                    intent.putExtra("iPhone XS MAX 256GB", message);
                    startActivity(intent);
                }
                // case for iphone xs 512GB
                if (groupPosition == 1 && childPosition == 2) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[1], apple_storage[3]};
                    intent.putExtra("iPhone XS MAX 512GB", message);
                    startActivity(intent);
                }
                // case for iphone xr 64GB
                if (groupPosition == 2 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[2], apple_storage[0]};
                    intent.putExtra("iPhone XR 64GB", message);
                    startActivity(intent);
                }
                // case for iphone xr 128GB
                if (groupPosition == 2 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[2], apple_storage[1]};
                    intent.putExtra("iPhone XR 256GB", message);
                    startActivity(intent);
                }
                // case for iphone xr 256GB
                if (groupPosition == 2 && childPosition == 2) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {apple_models[2], apple_storage[2]};
                    intent.putExtra("iPhone XR 512GB", message);
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
