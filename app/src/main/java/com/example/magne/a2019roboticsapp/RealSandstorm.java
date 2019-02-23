package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

public class RealSandstorm extends AppCompatActivity {

    public CheckBox sandstormListCB[] = new CheckBox[15];
    public boolean sandstormList[] = new boolean[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_sandstorm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }
    public void startTeleopActivity(View view){

        String[] newTeamInfo = getIntent().getStringArrayExtra("newTeamInfo");
        boolean[] beginningList = getIntent().getBooleanArrayExtra("beginningList");
        String event = getIntent().getStringExtra("event");

        Intent intent = new Intent(this, RealTeleOp.class);
        intent.putExtra("sandstormList", sandstormList);
        intent.putExtra("beginningList", beginningList);
        intent.putExtra("newTeamInfo", newTeamInfo);
        intent.putExtra("event",event);
        startActivity(intent);


        sandstormListCB = new CheckBox[]{
                sandstormListCB[0] =(CheckBox) findViewById(R.id.sandstormCargoCargoshipCB),
                sandstormListCB[1] = (CheckBox) findViewById(R.id.sandstormCargoCB),
                sandstormListCB[2] = (CheckBox) findViewById(R.id.sandstormCargoOneCB),
                sandstormListCB[3] = (CheckBox) findViewById(R.id.sandstormCargoTwoCB),
                sandstormListCB[4] = (CheckBox) findViewById(R.id.sandstormCargoThreeCB),
                sandstormListCB[5] = (CheckBox) findViewById(R.id.sandstormCargoRocketCB),
                sandstormListCB[6] = (CheckBox) findViewById(R.id.sandstormHatchCargoshipCB),
                sandstormListCB[7] = (CheckBox) findViewById(R.id.sandstormHatchCB),
                sandstormListCB[8] = (CheckBox) findViewById(R.id.sandstormHatchOneCB),
                sandstormListCB[9] = (CheckBox) findViewById(R.id.sandstormHatchTwoCB),
                sandstormListCB[10] = (CheckBox) findViewById(R.id.sandstormHatchThreeCB),
                sandstormListCB[11] = (CheckBox) findViewById(R.id.sandstormHatchRocketCB),
                sandstormListCB[12] = (CheckBox) findViewById(R.id.sandstormYesCB),
                sandstormListCB[13] = (CheckBox) findViewById(R.id.sandstormNoCB),
                sandstormListCB[14] = (CheckBox) findViewById(R.id.sandstormSuccessfulCB),
        };


        int i = 0;
        for (CheckBox CB: sandstormListCB){
            sandstormList[i] = CB.isChecked();
            i++;
        }

    }

}
