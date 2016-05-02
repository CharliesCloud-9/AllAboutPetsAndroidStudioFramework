package com.carlosgallegos.androidphpmysql;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by carlosgallegos on 4/26/16.
 */
public class Adapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> parentCategory;
    private List<String> childList;

    public Adapter(Context ctx, HashMap<String, List<String>> parentCategory, List<String> childList)
    {
        this.ctx = ctx;
        this.parentCategory = parentCategory;
        this.childList = childList;

    }

    @Override
    public Object getChild(int parentPosition, int childPosition) {

        return parentCategory.get(childList.get(parentPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int parentPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int parentPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parentView) {

        String childTitle = (String) getChild(parentPosition, childPosition);
        if (convertView == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.child_layout, parentView, false);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.child_txt);
        childTextView.setText(childTitle);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parentCategory.get(childList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return childList.get(groupPosition);
    }


    @Override
    public int getGroupCount() {
        return childList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int parentPosition, boolean isExpanded, View convertView, ViewGroup parentView) {

        String groupTitle = (String) getGroup(parentPosition);
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.parent_layout, parentView, false);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.parent_txt);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
