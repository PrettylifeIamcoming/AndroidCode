package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    private OrientationEventListener mOrientationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,60);
                toast.show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,60);
                toast.show();
            }
        });

        mOrientationListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int rotation) {
                if (((rotation >= 0) && (rotation <= 45)) || (rotation >= 315)) {
                    //portrait
                    Log.d("wen", "Screen orientation is Portrait!");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else if (((rotation > 225) && (rotation < 315))) {
                    //landscape
                    Log.d("wen", "Screen orientation is Landscape!");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else if (((rotation >= 135)&&(rotation <= 225))){
                    //reversePortrait
                    Log.d("wen", "Screen orientation is reversePortrait!");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                } else if (((rotation > 45) && (rotation < 135))){
                    //reverseLandscape
                    Log.d("wen", "Screen orientation is reverseLandscape!");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                }
            }
        };
        mOrientationListener.enable();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(QuizActivity.this, "横屏模式", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuizActivity.this, "竖屏模式", Toast.LENGTH_LONG).show();
        }

    }
}
