package com.example.translated_main_elements;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener  {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");

        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);


        mainEditText = findViewById(R.id.main_edittext);

        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);
     
        mainListView.setOnItemLongClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button:
                mainTextView.setText(mainEditText.getText().toString()
                        + " is learning Android development!");
                name = mainEditText.getText().toString();

                if (mNameList.contains(name.toString()) != true)
                {

                    mNameList.add(mainEditText.getText().toString());
                    Log.e("q", name);
                    Log.e("qqw", mNameList.get(0).toString());
                    Collections.sort(mNameList);
                } else {}
                mArrayAdapter.notifyDataSetChanged();
                break;

        }}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " is learning Android development!");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Удаляете Имя!")
                .setMessage("Удалить?")
                .setCancelable(false)
                .setNegativeButton("Да, удалить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                mNameList.remove(mNameList.get(position).toString());
                                mArrayAdapter.notifyDataSetChanged();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();


        return true;
    }




}
