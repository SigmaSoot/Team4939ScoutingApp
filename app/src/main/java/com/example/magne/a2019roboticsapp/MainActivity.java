package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

// take user to competition selection activity
public void startCompetitionActivity(View view){
        Intent intent = new Intent(this, Competitions.class);
        startActivity(intent);
}

// mainly testing button to take user straight to scoring page
public void startOtherActivity(View view){
        Intent intent2 = new Intent(this, RealBegginingLoc.class);
        startActivity(intent2);
}
}
