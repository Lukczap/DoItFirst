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

            yesNoEditText.setText("");

            generateYesNoButton.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    if(yesNoEditText.toString().trim().length()==0){
                        generateYesNoButton.setEnabled(false);
                    } else {
                        generateYesNoButton.setEnabled(true);
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });



        //generateYeNoButton.setEnabled(false);




        askAgainButton.setEnabled(true);






    }

    public void askAgain(View view) {

        answerYesNoTextView.setText("");
        yesNoEditText.setText("");

        generateYesNoButton.setEnabled(true);
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




    }


}
