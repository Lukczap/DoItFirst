package com.example.siemens.doitfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class YesOrNoActivity extends AppCompatActivity {

    Button generateYeNoButton;
    Button askAgainButton;
    TextView answerYesNoTextView;
    EditText yesNoEditText;


        public void generateAnswer(View view) {

                String[] sList = {"Yes", "No"};

        Random rand = new Random();

        final String s = sList[rand.nextInt(sList.length)];

        answerYesNoTextView.setText(s);

            yesNoEditText.setText("");



        //generateYeNoButton.setEnabled(false);

            if(yesNoEditText.getText().toString().trim().isEmpty()){
                generateYeNoButton.setEnabled(false);
            } else {
                generateYeNoButton.setEnabled(true);
            }


        askAgainButton.setEnabled(true);






    }

    public void askAgain(View view) {

        answerYesNoTextView.setText("");
        yesNoEditText.setText("");

        generateYeNoButton.setEnabled(true);
        askAgainButton.setEnabled(false);

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_or_no);

        generateYeNoButton = (Button) findViewById(R.id.generateYesNoButton);
        answerYesNoTextView = (TextView) findViewById(R.id.answerYesNoTextView);
        askAgainButton = (Button) findViewById(R.id.askAgainButton);
        yesNoEditText = (EditText) findViewById(R.id.yesNoEditText);




    }


}
