package com.example.quickoff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XiaomiModelsPageActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> models;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi_models_page);

        listView = (ExpandableListView)findViewById(R.id.xiaomi_models_list);
        initData();
        listAdapter = new MyExpandableListAdapter(this, models,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        models = new ArrayList<>();
        listHash = new HashMap<>();

        models.add("Mi9");

        List<String> mi_9 = new ArrayList<>();
        mi_9.add("128GB");
        mi_9.add("256GB");

        listHash.put(models.get(0),mi_9);

    }
}
