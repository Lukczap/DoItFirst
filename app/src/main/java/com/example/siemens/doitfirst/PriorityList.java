package com.example.siemens.doitfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class PriorityList extends AppCompatActivity {


    EditText itemEditText;
    Button addItemButton;
    Button removeItemButton;
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

        View.OnClickListener listenerDel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray checkedItemPosition = yourListView.getCheckedItemPositions();
                int itemCount = yourListView.getCount();

                for(int i=itemCount-1; i >= 0; i--){
                    if(checkedItemPosition.get(i)){
                        arrayAdapter.remove(arrayList.get(i));
                    }
                }
                checkedItemPosition.clear();
                arrayAdapter.notifyDataSetChanged();
            }
        };

        removeItemButton.setOnClickListener(listenerDel);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_list);

        itemEditText = (EditText) findViewById(R.id.itemEditText);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        removeItemButton = (Button) findViewById(R.id.removeItemButton);
        yourListView = (ListView) findViewById(R.id.yourListView);

        arrayList = new ArrayList();

        arrayAdapter = new ArrayAdapter(PriorityList.this, android.R.layout.simple_list_item_multiple_choice, arrayList);

        yourListView.setAdapter(arrayAdapter);

        addItemToList();

        removeItemFromList();








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
