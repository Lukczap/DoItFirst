package com.example.siemens.doitfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button yesOrNoActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        yesOrNoActivityButton = (Button) findViewById(R.id.yesOrNoActivityButton);
        yesOrNoActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent YesOrNoActivity = new Intent(SecondActivity.this, YesOrNoActivity.class);

                startActivity(YesOrNoActivity);
            }
        });
    }
}
