package com.example.quickoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    protected TextView idTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_second);
        idTvName = findViewById(R.id.id_tv_name);
        Intent intent = getIntent();
        idTvName.setText(intent.getStringExtra("name"));
    }

}
