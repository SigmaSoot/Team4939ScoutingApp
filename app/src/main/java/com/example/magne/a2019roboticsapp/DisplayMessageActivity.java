package com.example.magne.a2019roboticsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


// UI AND MISC TESTING

public class DisplayMessageActivity extends AppCompatActivity {

    private RadioGroup radioSandstormGroup;
    private RadioButton radioSandstormButton;
    private Button btnDone;
    private SeekBar seekBarHatch;
    private TextView textHatch;
    private RadioGroup radioCargoGroup;
    private RadioButton radioCargoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        addListenerScoring();


        // allowing Hatch seekBar to display number of hatches in textBox

        textHatch.setText(seekBarHatch.getProgress());
        seekBarHatch.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBarHatch, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBarHatch){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBarHatch){
                textHatch.setText(progress);
            }

        });

        }

    public void addListenerScoring(){
        radioSandstormGroup = (RadioGroup) findViewById(R.id.radioSandstormGroup);
        btnDone = (Button) findViewById(R.id.done);
        seekBarHatch = (SeekBar) findViewById(R.id.seekBarHatch);
        textHatch = (TextView) findViewById(R.id.textHatch);
        radioCargoGroup = (RadioGroup) findViewById(R.id.radioCargoGroup);


       btnDone.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                //  int selectedId = radioSandstormGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                //radioSandstormButton = (RadioButton) findViewById(selectedId);

                //String hatchesFinal = String.valueOf(textHatch.getText());

                //int selectedId2 = radioCargoGroup.getCheckedRadioButtonId();

                //radioSandstormButton = (RadioButton) findViewById(selectedId2);

                /* STILL NEED TO RETURN ALL OF THIS DATA! */




            }

        });
    }


}

