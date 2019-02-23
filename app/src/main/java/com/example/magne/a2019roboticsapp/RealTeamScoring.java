package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class RealTeamScoring extends AppCompatActivity {

    private DatabaseReference mDatabase;


    public CheckBox teamscoringListCB[] = new CheckBox[14];
    public Boolean teamscoringList[] = new Boolean[14];


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_team_scoring);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //dis de info bois :)


    }
    private List<Boolean> boolConverter (boolean[] primList, List<Boolean> objList){
        for (boolean bool : primList){
           Boolean i = Boolean.valueOf(bool);
           objList.add(i);
        }
        return objList;
    }
        public void startSubmitActivity (View view){

            mDatabase = FirebaseDatabase.getInstance().getReference();

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
            boolean[] beginningList = getIntent().getBooleanArrayExtra("beginningList");
            List<Boolean> BL = new ArrayList<>();
            BL = boolConverter(beginningList,BL);
            boolean[] sandstormList = getIntent().getBooleanArrayExtra("sandstormList");
            List<Boolean> SL = new ArrayList<>();
            SL = boolConverter(sandstormList,SL);
            boolean[] endgameList = getIntent().getBooleanArrayExtra("endgameList");
            List<Boolean> EL = new ArrayList<>();
            EL = boolConverter(endgameList,EL);
            HashMap<String, Boolean[]> teleopList = (HashMap<String, Boolean[]>)getIntent().getSerializableExtra("teleopList");
            String event = getIntent().getStringExtra("event");
            ArrayList<Integer> teleopTimes = getIntent().getIntegerArrayListExtra("teleopTimes");

            String[] newTeamInfo = getIntent().getStringArrayExtra("newTeamInfo");
            String time = getIntent().getStringExtra("endgameTime");

            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).setValue(newTeamInfo[0]);
            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Scouter Name").setValue(newTeamInfo[2]);
            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Beginning Info").setValue(BL);
            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Sandstorm Info").setValue(SL);
            int u = 0;
            for (HashMap.Entry<String,Boolean[]> whichCycle : teleopList.entrySet()){
                List<Boolean> prop =  Arrays.asList(whichCycle.getValue());
                mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Tele-Op Info").child(whichCycle.getKey()).setValue(prop);
                mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Tele-Op Info").child(whichCycle.getKey()).child("Time").setValue(teleopTimes.get(u));
                u++;
            }
            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Endgame Info").setValue(EL);
            mDatabase.child(event).child("Teams").child(newTeamInfo[1]).child("Endgame Info").child("Recovery Time").setValue(time);


            Intent intent = new Intent(this, RealSubmit.class);
            intent.putExtra("event",event);
            startActivity(intent);
        }

    }

