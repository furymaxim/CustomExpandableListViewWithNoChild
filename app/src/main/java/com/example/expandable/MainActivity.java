package com.example.expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListAdapter mAdapter;
    private ExpandableListView mExpandableListView;

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ExpandableListView");

        mExpandableListView = (ExpandableListView) findViewById(R.id.expandable);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Home");
        listDataHeader.add("Bhopal");
        listDataHeader.add("Indore");
        listDataHeader.add("Jaipur");
        listDataHeader.add("Udaipur");
        listDataHeader.add("Ajmer");
        listDataHeader.add("Jodhpur");
        listDataHeader.add("Chandigarh");
        listDataHeader.add("Lakhnow");

// Adding child data
        List<String> bhopal_ = new ArrayList<String>();
        bhopal_.add("About Us");
        bhopal_.add("Board Members");
        bhopal_.add("Chaiman Messages");

        List<String> indore_ = new ArrayList<String>();
        indore_.add("Heritage of Indore");
        indore_.add("City Map");

        List<String> udaipur_ = new ArrayList<String>();
        udaipur_.add("Live");
        udaipur_.add("Old");

        List<String> lakhnow_ = new ArrayList<String>();
        lakhnow_.add("Procurement");
        lakhnow_.add("Schemes");
        lakhnow_.add("Auctions");

        listDataChild.put(listDataHeader.get(1), bhopal_); // Header, Child data
        listDataChild.put(listDataHeader.get(2), indore_);
        listDataChild.put(listDataHeader.get(4), udaipur_);
        listDataChild.put(listDataHeader.get(8), lakhnow_);

        mAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);


        mExpandableListView.setAdapter(mAdapter);

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return true;
            }
        });
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        mExpandableListView
                .setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                    @Override
                    public void onGroupCollapse(int groupPosition) {

                    }
                });
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
    }

}
