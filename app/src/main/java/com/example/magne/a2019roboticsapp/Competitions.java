package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Competitions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeVars();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    //just initializing the image buttons so they can be used
    public void initializeVars(){
        ImageButton btnHumber = (ImageButton) findViewById(R.id.humberCollege);
        ImageButton btnRyerson = (ImageButton) findViewById(R.id.ryersonUniversity);
    }

    public void humberSelection(View view){
        Intent intent = new Intent(this, HumberSelection.class);
        startActivity(intent);
    }

    public void ryersonSelection(View view){
        Intent intent = new Intent(this, RyersonSelection.class);
        startActivity(intent);
    }
}
