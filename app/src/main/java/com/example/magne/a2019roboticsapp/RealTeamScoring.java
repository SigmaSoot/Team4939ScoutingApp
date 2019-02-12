package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

public class RealTeamScoring extends AppCompatActivity {

    public CheckBox teamscoringListCB[] = new CheckBox[14];
    public Boolean teamscoringList[] = new Boolean[14];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_team_scoring);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //dis de info bois :)
        boolean[] beginningList = getIntent().getBooleanArrayExtra("beginningList");
        boolean[] sandstormList = getIntent().getBooleanArrayExtra("sandstormList");
        boolean[] endgameList = getIntent().getBooleanArrayExtra("endgameList");
        boolean[] teleopList = getIntent().getBooleanArrayExtra("teleopList");
        String time = getIntent().getStringExtra("endgameTime");

    }

        public void startSubmitActivity (View view){
            Intent intent = new Intent(this, RealSubmit.class);
            startActivity(intent);

            teamscoringListCB = new CheckBox[]{
                    teamscoringListCB[0] = (CheckBox) findViewById(R.id.cargoRocketCB),
                    teamscoringListCB[1] = (CheckBox) findViewById(R.id.hatchShipCB),
                    teamscoringListCB[2] = (CheckBox) findViewById(R.id.cargoShipCB),
                    teamscoringListCB[3] = (CheckBox) findViewById(R.id.hatchRocketCB),
                    teamscoringListCB[4] = (CheckBox) findViewById(R.id.climbNoCB),
                    teamscoringListCB[5] = (CheckBox) findViewById(R.id.climbYesCB),
                    teamscoringListCB[6] = (CheckBox) findViewById(R.id.platformOneCB),
                    teamscoringListCB[7] = (CheckBox) findViewById(R.id.platformThreeCB),
                    teamscoringListCB[8] = (CheckBox) findViewById(R.id.platformTwoCB),
                    teamscoringListCB[9] = (CheckBox) findViewById(R.id.speedFastCB),
                    teamscoringListCB[10] = (CheckBox) findViewById(R.id.speedMediumCB),
                    teamscoringListCB[11] = (CheckBox) findViewById(R.id.speedSlowCB),
                    teamscoringListCB[12] = (CheckBox) findViewById(R.id.drivingCoordinateCB),
                    teamscoringListCB[13] = (CheckBox) findViewById(R.id.drivingPushyCB)
            };

            int i = 0;
            for (CheckBox CB: teamscoringListCB){
                teamscoringList[i] = CB.isChecked();
                i++;
            }

            //WRITE INFO TO FIREBASE

        }

    }

