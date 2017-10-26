package com.keysight.softwarecontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String POINT_A = "Point a";
    public static final String POINT_B = "Point b";
    public static final String POINT_X1 = "Point x1";
    public static final String POINT_Y1 = "Point y1";
    public static final String POINT_X2 = "Point x2";
    public static final String POINT_Y2 = "Point y2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Submit Transaction button */
    public void calculate(View view) {
        Intent intent = new Intent(this, Calculation.class);
        intent.putExtra(POINT_A, ((EditText) findViewById(R.id.editText_a)).getText().toString());
        intent.putExtra(POINT_B, ((EditText) findViewById(R.id.editText_b)).getText().toString());
        intent.putExtra(POINT_X1, ((EditText) findViewById(R.id.editText_x1)).getText().toString());
        intent.putExtra(POINT_Y1, ((EditText) findViewById(R.id.editText_y1)).getText().toString());
        intent.putExtra(POINT_X2, ((EditText) findViewById(R.id.editText_x2)).getText().toString());
        intent.putExtra(POINT_Y2, ((EditText) findViewById(R.id.editText_y2)).getText().toString());
        startActivity(intent);
    }
}
