package com.example.translated_guess_the_number;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView tvInfo;
    EditText etInput;
    Button bControl,b2;
    int max,main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        etInput.setOnClickListener(this);
        b2.setOnClickListener(this);
        Switch switch1 =  findViewById(R.id.level);
        if (switch1 != null) {
            switch1.setOnCheckedChangeListener(this);
        }
        max = 100;
        main = (int)(Math.random() * max);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                String text = etInput.getText().toString();
                if(text.length() == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("ВНИМАНИЕ")
                            .setMessage("Напишите хоть что-то")
                            .setCancelable(false)
                            .setNegativeButton("Ладно",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else {
                    int value = Integer.parseInt(etInput.getText().toString());
                    if(value < 1 || value > max){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("ВНИМАНИЕ")
                                .setMessage("Это число не подходит")
                                .setCancelable(false)
                                .setNegativeButton("Ладно",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    else{
                        if(value < main ) {
                            tvInfo.setText(getResources().getString(R.string.behind));
                        }
                        if(value > main ) {
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        }
                        if(value == main ) {
                            tvInfo.setText(getResources().getString(R.string.hit));
                        }
                    }
                }
                break;
            case R.id.button2:
                this.finish();
                break;
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // если 200
            max = 200;
            tvInfo.setText(getResources().getString(R.string.try_to_guess2));
            main = (int)(Math.random() * max);
        } else {
            // если 100
            max = 100;
            main = (int)(Math.random() * max);
        }
    }
}

