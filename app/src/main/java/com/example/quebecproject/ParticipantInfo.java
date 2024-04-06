package com.example.quebecproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.ColorInt;

public class ParticipantInfo extends Activity implements OnClickListener {

    final static String MYDEBUG = "MYDEBUG";
    EditText nameField;
    Button buttonOneHanded, buttonTwoHanded, buttonStart;
    String handPosture;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.participant_info);

        nameField = (EditText) findViewById(R.id.textFieldName);

        buttonOneHanded = (Button) findViewById(R.id.buttonOneHanded);
        buttonOneHanded.setOnClickListener(this);

        buttonTwoHanded = (Button) findViewById(R.id.buttonTwoHanded);
        buttonTwoHanded.setOnClickListener(this);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

        handPosture = "single"; // default setting one hand?
    }

    @Override
    public void onClick(View v) {
        if (v == buttonOneHanded) {
            handPosture = "single";
            buttonOneHanded.setBackgroundColor(Color.GRAY);
            buttonTwoHanded.setBackgroundColor(Color.LTGRAY);

            Log.i(MYDEBUG, "one hand pressed");
        } else if (v == buttonTwoHanded) {
            handPosture = "double";
            buttonOneHanded.setBackgroundColor(Color.LTGRAY);
            buttonTwoHanded.setBackgroundColor(Color.GRAY);

            Log.i(MYDEBUG, "two hand pressed");
        } else if (v == buttonStart) {
            // bundle the parameters to pass on to activity
            Bundle b = new Bundle();
            b.putString("name", nameField.getText().toString());
            b.putString("handPosture", handPosture);

            Log.i(MYDEBUG, "name: " + nameField.getText().toString());
            Log.i(MYDEBUG, "hand posture: " + handPosture);
            /*
            // start the game
            Intent i = new Intent(getApplicationContext(), //the tests/level java file name goes here);
            i.putExtras(b);
            startActivity(i);
             */

        } else {
            // do nothing
        }
    }
}