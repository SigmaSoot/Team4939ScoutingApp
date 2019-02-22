package com.example.magne.a2019roboticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class RealNewTeam extends AppCompatActivity {

    String info[] = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_new_team);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void startBeginningLocation(View view){
        EditText gameNumber = findViewById(R.id.gameNumber);
        info[0] = gameNumber.getText().toString();
        EditText teamNumber = findViewById(R.id.teamNumber);
        info[1] = teamNumber.getText().toString();
        EditText scouterName = findViewById(R.id.scouterName);
        info[2] = scouterName.getText().toString();

        Intent intent = new Intent(this, RealBegginingLoc.class);
        intent.putExtra("newTeamInfo", info);
        startActivity(intent);
    }

}
