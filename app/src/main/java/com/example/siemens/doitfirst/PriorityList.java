package com.example.siemens.doitfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PriorityList extends AppCompatActivity {


    EditText itemEditText;
    Button addItemButton;
    TextView yourListTextView;

    public void addItemToList(View view){

        String i = itemEditText.getText().toString();

        yourListTextView.setText(i);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_list);

        itemEditText = (EditText) findViewById(R.id.itemEditText);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        yourListTextView = (TextView) findViewById(R.id.yourListTextView);

        itemEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
