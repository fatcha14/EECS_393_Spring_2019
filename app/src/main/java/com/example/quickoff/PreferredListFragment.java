package com.example.quickoff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PreferredListFragment extends Fragment {

    static PreferredList preferredList = new PreferredList();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preferred_list, container, false);
        initData();
        String[] phone_name = preferredList.asArray();
        ListView phoneListView = (ListView) view.findViewById(R.id.preferred_list);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, phone_name);
        phoneListView.setAdapter(listAdapter);

        return view;
    }

    private static void initData() {

        preferredList.add(new Product(true, "iphone", 1200.00));
    }

}
