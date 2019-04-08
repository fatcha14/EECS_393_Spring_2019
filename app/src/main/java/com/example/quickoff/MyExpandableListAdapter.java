package com.example.quickoff;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private List<String> models;
    private HashMap<String,List<String>> storage;

    public MyExpandableListAdapter(Context context, List<String> models, HashMap<String, List<String>> storage) {
        this.context = context;
        this.models = models;
        this.storage = storage;
    }

    @Override
    public int getGroupCount() {
        return models.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return storage.get(models.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return models.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return storage.get(models.get(groupPosition)).get(childPosition); // i = Group Item , i1 = ChildItem
    }

    @Override
    public long getGroupId(int groupPostition) {
        return groupPostition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(groupPosition);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group,null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        final String childText = (String)getChild(groupPosition,childPosition);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);
        }

        TextView txtListChild = (TextView)view.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
