package com.example.expandable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    Context mContext;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    public ExpandableListAdapter(Context mContext, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this.mContext = mContext;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //return listDataChild.get(listDataHeader.get(groupPosition)).size();
        Log.d("myLogs",String.valueOf(groupPosition));
        try{
            return listDataChild.get(listDataHeader.get(groupPosition)).size();
        }catch (NullPointerException e){

            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String header_title = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_item, null);
        }


        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.img);
        TextView tv_head_txt = (TextView) convertView.findViewById(R.id.group);
        ImageView imageView = convertView.findViewById(R.id.group_image);
        //imageView.setImageBitmap(icon);
        tv_head_txt.setText(header_title);

        if (getChildrenCount(groupPosition) == 0) {
            imageView.setVisibility(View.INVISIBLE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(isExpanded ? R.drawable.ic_launcher_background : R.drawable.ic_launcher_foreground);
            tv_head_txt.setText(header_title);

        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String child_title = String.valueOf(getChild(groupPosition, childPosition));
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_item, null);
        }

        TextView tv_head_txt = (TextView) convertView.findViewById(R.id.item);
        tv_head_txt.setText(child_title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
