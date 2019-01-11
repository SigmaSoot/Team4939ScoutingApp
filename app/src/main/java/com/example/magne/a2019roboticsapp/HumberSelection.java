package com.example.magne.a2019roboticsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HumberSelection extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humber_selection);
        initTeams();
    }

    private void initTeams(){
        mNames.add("2222");
        mNames.add("4242");
        mNames.add("983");
        mNames.add("34");
        mNames.add("6286");
        mNames.add("1241");
        mNames.add("254");
        mNames.add("7");
        mNames.add("4039");
        mNames.add("4939");
        mNames.add("2222");
        mNames.add("4242");
        mNames.add("983");
        mNames.add("34");
        mNames.add("6286");
        mNames.add("1241");
        mNames.add("254");
        mNames.add("7");
        mNames.add("4039");
        mNames.add("4939");

        initRecyclerview();
    }

    private void initRecyclerview(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewHumber);
        RecycleviewAdapter adapter = new RecycleviewAdapter(mNames,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
