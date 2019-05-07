package com.github.prettylife.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SingleTopActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

        Log.d("TopLifecycle", "onCreate");
        Log.d("Top1", "TaskID = " + getTaskId());
        Log.d("Top1", "Activity地址：" + toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TopLifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TopLifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TopLifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TopLifecycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TopLifecycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TopLifecycle", "onDestory");
    }

}
