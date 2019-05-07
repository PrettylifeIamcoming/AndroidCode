package com.github.prettylife.launchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StandardActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

        Log.d("StandardLifecycle", "onCreate");
        Log.d("Standard1", "TaskID = " + getTaskId());
        Log.d("Standard1", "Activity地址：" + toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("StandardLifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("StandardLifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("StandardLifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("StandardLifecycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("StandardLifecycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("StandardLifecycle", "onDestory");
    }
}
