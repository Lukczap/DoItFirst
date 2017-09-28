package com.example.siemens.doitfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class YesOrNoActivity extends AppCompatActivity {

    Button generateYesNoButton;
    Button askAgainButton;
    TextView answerYesNoTextView;
    EditText yesNoEditText;

        public void generateAnswer(View view) {

            String[] sList = {"Yes", "No"};

        Random rand = new Random();

        final String s = sList[rand.nextInt(sList.length)];

        answerYesNoTextView.setText(s);

        generateYesNoButton.setEnabled(false);

        askAgainButton.setEnabled(true);

    }

    public void askAgain(View view) {

        answerYesNoTextView.setText("");
        yesNoEditText.setText("");

        askAgainButton.setEnabled(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_or_no);

        generateYesNoButton = (Button) findViewById(R.id.generateYesNoButton);
        answerYesNoTextView = (TextView) findViewById(R.id.answerYesNoTextView);
        askAgainButton = (Button) findViewById(R.id.askAgainButton);
        yesNoEditText = (EditText) findViewById(R.id.yesNoEditText);

        generateYesNoButton.setEnabled(false);

        yesNoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                generateYesNoButton.setEnabled(true);

            }

            @Override
            public void afterTextChanged(Editable yesNoEditText) {

                if(yesNoEditText.length() == 0) {
                    generateYesNoButton.setEnabled(false);
                } else {
                    generateYesNoButton.setEnabled(true);
                }

            }
        });




    }


}
