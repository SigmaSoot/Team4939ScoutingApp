package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class RealTeleOp extends AppCompatActivity {

    private boolean isStart;
    private Chronometer chronometer;
    private int cycleNum = 1;

    private CheckBox teleopList[] = {
            (findViewById(R.id.hatchTeleCB)), (findViewById(R.id.yesCargoTeleCB)), (findViewById(R.id.noCargoTeleCB)),
            (findViewById(R.id.rocketHatchTeleCB)), (findViewById(R.id.oneRocketHatchCB)), (findViewById(R.id.twoRocketHatchCB)),
            (findViewById(R.id.threeRocketHatchCB)), (findViewById(R.id.cargoHatchCB)), (findViewById(R.id.yesHatchCB)),
            (findViewById(R.id.noHatchCB)), (findViewById(R.id.cargoTeleCB)), (findViewById(R.id.rocketCargoTeleCB)),
            (findViewById(R.id.oneRocketCargoTeleCB)), (findViewById(R.id.twoRocketCargoCB)), (findViewById(R.id.threeRocketCargoCB)),
            (findViewById(R.id.cargoCargoTeleCB))
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_tele_op);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        chronometer = findViewById(R.id.chronometer1);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });



    }

    public void startEndgameActivity(View view){
        Intent intent = new Intent(this, RealTeamEndgame.class);
        startActivity(intent);
    }

    public void startStopChronometer(View view) {
        if (isStart) {
            chronometer.stop();
            isStart = false;
            ((Button) view).setText("START");
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isStart = true;
            ((Button) view).setText("STOP");
        }
    }

    public void nextCycle(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        cycleNum++;
        String titleChange = String.format("Cycle %d", cycleNum);
        ((TextView) findViewById(R.id.cycleTitle)).setText(titleChange);
        //ADD STORAGE OF THE PREVIOUS CYCLE'S INFO FUNCTIONALITY
        //RESET SCREEN FUNCTIONALITY
        for (CheckBox CB: teleopList){
            CB.setChecked(false);
        }


    }

}
