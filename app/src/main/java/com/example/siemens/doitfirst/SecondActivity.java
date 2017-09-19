package com.example.siemens.doitfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button yesOrNoButton;
    Button toDoListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        toDoListButton = (Button) findViewById(R.id.toDoListButton);
        toDoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent PriorityList = new Intent(SecondActivity.this, PriorityList.class);

                startActivity(PriorityList);
            }
        });

        yesOrNoButton = (Button) findViewById(R.id.yesOrNoButton);
        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent YesOrNoActivity = new Intent(SecondActivity.this, YesOrNoActivity.class);

                startActivity(YesOrNoActivity);
            }
        });
    }
}
