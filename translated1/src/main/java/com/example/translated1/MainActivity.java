package com.example.translated1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.translated1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1,tv2;
    Button decr,cl;
    ImageButton btn;
    int num=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv2 = findViewById(R.id.tv2);
        tv1 = findViewById(R.id.tv1);
        btn = findViewById(R.id.button1);
        decr = findViewById(R.id.decrease);
        cl = findViewById(R.id.clear);

        btn.setOnClickListener(this);

        decr.setOnClickListener(this);
        cl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                num = num+1;
                tv1.setText(Integer.toString(num));
                if (num==1)
                {
                    tv2.setText("time.");
                }
                else
                {tv2.setText("times.");}
                break;

            case R.id.decrease:
                if (num>0)
                {
                    num = num - 1;
                }
                if (num>=0)
                {
                    tv1.setText(Integer.toString(num));
                }
                if (num==1)
                {
                    tv2.setText("time.");
                }else{tv2.setText("times.");}
                break;

            case R.id.clear:
                num=0;
                tv1.setText(Integer.toString(num));
                break;


        }}
}
