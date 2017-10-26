package com.keysight.softwarecontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Calculation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        double a = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_A));
        double b = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_B));
        double x1 = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_X1));
        double y1 = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_Y1));
        double x2 = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_X2));
        double y2 = Double.parseDouble(intent.getStringExtra(MainActivity.POINT_Y2));

        String resultMessage = "";
        if (x1 == x2) {
            if (y1 == y2) {
                resultMessage = "invalid parameters - the coordinates of the 2 points for the straight line are the same.";
            } else {
                if (a > x1) {
                    resultMessage = "the straight line is VERTICAL and the point is to the RIGHT of the straight line.";
                } else if (a < x1) {
                    resultMessage = "the straight line is VERTICAL and the point is to the LEFT of the straight line.";
                } else {
                    resultMessage = "the straight line is VERTICAL and the point is EXACTLY ON the straight line.";
                }
            }
        } else {
            double slope_k = (y2 - y1) / (x2 - x1);
            double slope_b = y1 - slope_k * x1;
            double slope_y = slope_k * a + slope_b;
            if (b > slope_y) {
                resultMessage = "the point is ABOVE the straight line.";
            } else if (b < slope_y) {
                resultMessage = "the point is UNDER the straight line.";
            } else {
                resultMessage = "the point is EXACTLY ON the straight line.";
            }
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("The result is: " + resultMessage);
    }
}
