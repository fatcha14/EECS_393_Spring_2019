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

public class SamsungModelsPageActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> models;
    private HashMap<String,List<String>> listHash;
    String company =  "Samsung";
    String[] samsung_models = {"S10", "S10+", "S10e"};
    String[] samsung_storage = {"64GB", "128GB", "256GB", "512GB"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_models_page);

        listView = (ExpandableListView)findViewById(R.id.apple_models_list);
        initData();
        listAdapter = new MyExpandableListAdapter(this, models,listHash);
        listView.setAdapter(listAdapter);

        // send the models and storage data to backend for search query
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                                        int groupPosition, int childPosition, long id) {
                // case for s10 64GB
                if (groupPosition == 0 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[0], samsung_storage[1], company};
                    intent.putExtra("S10 128GB", message);
                    startActivity(intent);
                }
                // case for s10 512GB
                if (groupPosition == 0 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[0], samsung_storage[3], company};
                    intent.putExtra("S10 512GB", message);
                    startActivity(intent);
                }
                // case for s10+ 128GB
                if (groupPosition == 1 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[1], samsung_storage[1], company};
                    intent.putExtra("S10+ 128GB", message);
                    startActivity(intent);
                }
                // case for s10+ 512GB
                if (groupPosition == 1 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[1], samsung_storage[3], company};
                    intent.putExtra("S10+ 512GB", message);
                    startActivity(intent);
                }
                // case for s10e 128GB
                if (groupPosition == 2 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[2], samsung_storage[1], company};
                    intent.putExtra("S10e 128GB", message);
                    startActivity(intent);
                }
                // case for s10e 256GB
                if (groupPosition == 2 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {samsung_models[2], samsung_storage[2], company};
                    intent.putExtra("S10e 256GB", message);
                    startActivity(intent);
                }


                return false;
            }
        });

    }

    private void initData() {
        models = new ArrayList<>();
        listHash = new HashMap<>();

        models.add("S10");
        models.add("S10+");
        models.add("S10e");

        List<String> s10 = new ArrayList<>();
        s10.add("128GB");
        s10.add("512GB");

        List<String> S10_Plus = new ArrayList<>();
        S10_Plus.add("128GB");;
        S10_Plus.add("512GB");

        List<String> s10_e = new ArrayList<>();
        s10_e.add("128GB");
        s10_e.add("256GB");


        listHash.put(models.get(0),s10);
        listHash.put(models.get(1),S10_Plus);
        listHash.put(models.get(2),s10_e);
    }
}