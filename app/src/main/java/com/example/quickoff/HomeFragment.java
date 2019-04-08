package com.example.quickoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";

    protected Button serachButton;
    protected TextInputEditText edittext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        serachButton = rootView.findViewById(R.id.serach_button);
        serachButton.setOnClickListener(HomeFragment.this);
        edittext = rootView.findViewById(R.id.edittext);




        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.serach_button) {
            //这些操作，同时传递参数
            String name = edittext.getText().toString();
            Log.i(TAG, "onClick: edittext===" + name);
            Toast.makeText(this.getActivity(), name, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this.getActivity(), AppleModelsPageActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

}
