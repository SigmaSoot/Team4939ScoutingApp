package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class RealTeamEndgame extends AppCompatActivity {

    public CheckBox endgameListCB[] = new CheckBox[6];
    public String time;
    public boolean endgameList[] = new boolean[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_team_endgame);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startScoringActivity(View view){
        endgameListCB = new CheckBox[]{
                endgameListCB[0] = (CheckBox) findViewById(R.id.endgameRecoverNoCB),
                endgameListCB[1] = (CheckBox) findViewById(R.id.endgameRecoverYesCB),
                endgameListCB[2] = (CheckBox) findViewById(R.id.endgameStopNoCB),
                endgameListCB[3] = (CheckBox) findViewById(R.id.endgameStopYesCB),
                endgameListCB[4] = (CheckBox) findViewById(R.id.endgameTipNoCB),
                endgameListCB[5] = (CheckBox) findViewById(R.id.endgameTipYesCB)
        };
        EditText g = (EditText) findViewById(R.id.endgameTime);
        time = g.getText().toString();

        int i = 0;
        for(CheckBox CB:endgameListCB){
            endgameList[i] = CB.isChecked();
            i++;
        }

        String[] newTeamInfo = getIntent().getStringArrayExtra("newTeamInfo");
        boolean[] beginningList = getIntent().getBooleanArrayExtra("beginningList");
        boolean[] sandstormList = getIntent().getBooleanArrayExtra("sandstormList");
        boolean[] teleopList = getIntent().getBooleanArrayExtra("teleopList");

        Intent intent = new Intent(this, RealTeamScoring.class);
        intent.putExtra("newTeamInfo",newTeamInfo);
        intent.putExtra("beginningList",beginningList);
        intent.putExtra("sandstormList",sandstormList);
        intent.putExtra("teleopList",teleopList);
        intent.putExtra("endgameList", endgameList);
        intent.putExtra("endgameTime", time);
        startActivity(intent);
    }
}
