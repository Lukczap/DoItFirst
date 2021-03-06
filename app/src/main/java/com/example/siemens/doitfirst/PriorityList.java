package com.example.siemens.doitfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class PriorityList extends AppCompatActivity {

    EditText itemEditText;
    Button addItemButton;
    Button generateListButton;
    Button newListButton;
    ListView yourListView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    public void addItemToList(){

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = itemEditText.getText().toString();
                arrayList.add(item);
                arrayAdapter.notifyDataSetChanged();
                itemEditText.setText("");
            }
        });
    }

    public void removeItemFromList(){

        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                arrayList.remove(position);

                yourListView.invalidateViews();

            }
        });
    }

    public void generateList(){

        generateListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList kopia = (ArrayList) arrayList.clone();

                do {
                    Collections.shuffle(arrayList);
                } while (kopia.equals(arrayList));

                arrayAdapter.notifyDataSetChanged();

                generateListButton.setEnabled(false);
                itemEditText.setEnabled(false);
                yourListView.setEnabled(false);
            }
        });
    }

    public void newList(){

        newListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent PriorityList = new Intent(PriorityList.this, PriorityList.class);

                startActivity(PriorityList);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_list);

        itemEditText = (EditText) findViewById(R.id.itemEditText);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        generateListButton = (Button) findViewById(R.id.generateListButton);
        newListButton = (Button) findViewById(R.id.newListButton);
        yourListView = (ListView) findViewById(R.id.yourListView);

        arrayList = new ArrayList();

        arrayAdapter = new ArrayAdapter(PriorityList.this, android.R.layout.simple_list_item_1, arrayList);

        yourListView.setAdapter(arrayAdapter);

        addItemToList();

        removeItemFromList();

        addItemButton.setEnabled(false);

        generateList();

        newList();




        itemEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                addItemButton.setEnabled(true);

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(itemEditText.length() == 0) {
                    addItemButton.setEnabled(false);
                } else {
                    addItemButton.setEnabled(true);
                }
            }
        });
    }
}
