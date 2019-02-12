package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;


import java.util.Arrays;
import java.util.List;


public class RealBegginingLoc extends AppCompatActivity {

    public Boolean beginningList[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_beggining_loc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startSandstormActivity(View view){
        beginningList = new Boolean[2];
        CheckBox o;
        o = findViewById(R.id.oneBeginningLoc);
        beginningList[0] = o.isChecked();
        o = findViewById(R.id.twoBeginningLoc);
        beginningList[1] = o.isChecked();

        Intent intent = new Intent(this, RealSandstorm.class);
        intent.putExtra("beginningList", beginningList);
        startActivity(intent);
    }

}
