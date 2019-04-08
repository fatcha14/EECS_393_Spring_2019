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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";

    protected Button serachButton;
    protected TextInputEditText edittext;

    String[] brands = {"Apple", "Samsung", "Xiaomi", "LG"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ListView brandsListView = (ListView) rootView.findViewById(R.id.brands_list);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, brands);
        brandsListView.setAdapter(listAdapter);
        brandsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (position == 0) {
                   Intent apple_intent = new Intent(view.getContext(), AppleModelsPageActivity.class);
                   startActivity(apple_intent);
               }
               if (position == 1) {
                   Intent samsung_intent = new Intent(view.getContext(), SamsungModelsPageActivity.class);
                   startActivity(samsung_intent);
               }
               if (position == 2) {
                   Intent xiaomi_intent = new Intent(view.getContext(), XiaomiModelsPageActivity.class);
                   startActivity(xiaomi_intent);
               }
           }
        });

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
