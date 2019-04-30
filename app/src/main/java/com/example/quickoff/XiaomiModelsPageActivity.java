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

public class XiaomiModelsPageActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> models;
    private HashMap<String,List<String>> listHash;
    String company =  "XiaoMi";
    String[] xiaomi_models = {"Mi9"};
    String[] xiaomi_storage = {"128GB", "256GB"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi_models_page);

        listView = (ExpandableListView)findViewById(R.id.xiaomi_models_list);
        initData();
        listAdapter = new MyExpandableListAdapter(this, models,listHash);
        listView.setAdapter(listAdapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                                        int groupPosition, int childPosition, long id) {
                // case for s10 128GB
                if (groupPosition == 0 && childPosition == 0) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {xiaomi_models[0], xiaomi_storage[0], company};
                    intent.putExtra("S10 128GB", message);
                    startActivity(intent);
                }
                // case for Mi9 256GB
                if (groupPosition == 0 && childPosition == 1) {
                    Intent intent = new Intent(view.getContext(), SearchResultActivity.class);
                    String message[] = {xiaomi_models[0], xiaomi_storage[1], company};
                    intent.putExtra("S10 512GB", message);
                    startActivity(intent);
                }
                return false;
            }
        });
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
