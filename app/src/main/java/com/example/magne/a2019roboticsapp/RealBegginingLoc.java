package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;




public class RealBegginingLoc extends AppCompatActivity {

    public boolean beginningList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_beggining_loc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startSandstormActivity(View view){
        beginningList = new boolean[2];
        CheckBox o;
        o = findViewById(R.id.oneBeginningLoc);
        beginningList[0] = o.isChecked();
        o = findViewById(R.id.twoBeginningLoc);
        beginningList[1] = o.isChecked();


        String[] newTeamInfo = getIntent().getStringArrayExtra("newTeamInfo");
        String event = getIntent().getStringExtra("event");

        Intent intent = new Intent(this, RealSandstorm.class);
        intent.putExtra("beginningList", beginningList);
        intent.putExtra("newTeamInfo", newTeamInfo);
        intent.putExtra("event", event);
        startActivity(intent);
    }

}
