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

import java.util.HashMap;

//NEEDS DEBUGGING - NULLPOINTEREXCEPTION

public class RealTeleOp extends AppCompatActivity {

    private boolean isStart;
    private Chronometer chronometer;

    private int cycleNum = 1;
    public CheckBox teleopList[] = new CheckBox[16];
    public HashMap<String,Boolean[]> cycleList = new HashMap<>();






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
        teleopList = new CheckBox[]{
                teleopList[3] = (CheckBox) findViewById(R.id.cargoCargoTeleCB),
                teleopList[1] = (CheckBox) findViewById(R.id.yesCargoTeleCB),
                teleopList[2] = (CheckBox) findViewById(R.id.noCargoTeleCB),
                teleopList[0] = (CheckBox) findViewById(R.id.hatchTeleCB),
                teleopList[4] = (CheckBox) findViewById(R.id.rocketHatchTeleCB),
                teleopList[5] = (CheckBox) findViewById(R.id.oneRocketHatchCB),
                teleopList[6] = (CheckBox) findViewById(R.id.twoRocketHatchCB),
                teleopList[7] = (CheckBox) findViewById(R.id.threeRocketHatchCB),
                teleopList[8] = (CheckBox) findViewById(R.id.cargoHatchCB),
                teleopList[9] = (CheckBox) findViewById(R.id.yesHatchCB),
                teleopList[10] = (CheckBox) findViewById(R.id.noHatchCB),
                teleopList[11] = (CheckBox) findViewById(R.id.cargoTeleCB),
                teleopList[12] = (CheckBox) findViewById(R.id.oneRocketCargoTeleCB),
                teleopList[13] = (CheckBox) findViewById(R.id.twoRocketCargoCB),
                teleopList[14] = (CheckBox) findViewById(R.id.threeRocketCargoCB),
                teleopList[15] = (CheckBox) findViewById(R.id.rocketCargoTeleCB)
        };
        cycleList.put(String.format("cycle%d", cycleNum), new Boolean[]{
                teleopList[0].isChecked(),teleopList[1].isChecked(),teleopList[2].isChecked(),
                teleopList[3].isChecked(),teleopList[4].isChecked(),teleopList[5].isChecked(),
                teleopList[6].isChecked(),teleopList[7].isChecked(),teleopList[8].isChecked(),
                teleopList[9].isChecked(),teleopList[10].isChecked(),teleopList[11].isChecked(),
                teleopList[12].isChecked(),teleopList[13].isChecked(),teleopList[14].isChecked(),
                teleopList[15].isChecked()
        });

        boolean[] beginningList = getIntent().getBooleanArrayExtra("beginningList");
        String[] newTeamInfo = getIntent().getStringArrayExtra("newTeamInfo");
        boolean[] sandstormList = getIntent().getBooleanArrayExtra("sandstormList");

        Intent intent = new Intent(this, RealTeamEndgame.class);
        intent.putExtra("newTeamInfo", newTeamInfo);
        intent.putExtra("beginningList", beginningList);
        intent.putExtra("sandstormList", sandstormList);
        intent.putExtra("teleopList",cycleList);
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
        teleopList = new CheckBox[]{
            teleopList[3] = (CheckBox) findViewById(R.id.cargoCargoTeleCB),
            teleopList[1] = (CheckBox) findViewById(R.id.yesCargoTeleCB),
            teleopList[2] = (CheckBox) findViewById(R.id.noCargoTeleCB),
            teleopList[0] = (CheckBox) findViewById(R.id.hatchTeleCB),
            teleopList[4] = (CheckBox) findViewById(R.id.rocketHatchTeleCB),
            teleopList[5] = (CheckBox) findViewById(R.id.oneRocketHatchCB),
            teleopList[6] = (CheckBox) findViewById(R.id.twoRocketHatchCB),
            teleopList[7] = (CheckBox) findViewById(R.id.threeRocketHatchCB),
            teleopList[8] = (CheckBox) findViewById(R.id.cargoHatchCB),
            teleopList[9] = (CheckBox) findViewById(R.id.yesHatchCB),
            teleopList[10] = (CheckBox) findViewById(R.id.noHatchCB),
            teleopList[11] = (CheckBox) findViewById(R.id.cargoTeleCB),
            teleopList[12] = (CheckBox) findViewById(R.id.oneRocketCargoTeleCB),
            teleopList[13] = (CheckBox) findViewById(R.id.twoRocketCargoCB),
            teleopList[14] = (CheckBox) findViewById(R.id.threeRocketCargoCB),
            teleopList[15] = (CheckBox) findViewById(R.id.rocketCargoTeleCB)
        };

        //Storing cycle values in HashMap
        cycleList.put(String.format("cycle%d", cycleNum), new Boolean[]{
                teleopList[0].isChecked(),teleopList[1].isChecked(),teleopList[2].isChecked(),
                teleopList[3].isChecked(),teleopList[4].isChecked(),teleopList[5].isChecked(),
                teleopList[6].isChecked(),teleopList[7].isChecked(),teleopList[8].isChecked(),
                teleopList[9].isChecked(),teleopList[10].isChecked(),teleopList[11].isChecked(),
                teleopList[12].isChecked(),teleopList[13].isChecked(),teleopList[14].isChecked(),
                teleopList[15].isChecked()
        });

       for (CheckBox CB: teleopList) CB.setChecked(false);

    }

}
