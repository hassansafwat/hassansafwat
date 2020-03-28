package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1= (TextView) findViewById(R.id.Text_view1);
        t3= (TextView) findViewById(R.id.Text_view3);
        t2= (TextView) findViewById(R.id.Text_view2);

        Intent i = getIntent();
        String question = i.getStringExtra("total");
        String wrong = i.getStringExtra("incorrect");
        String correct = i.getStringExtra("correct");
        t1.setText(question);
        t2.setText(wrong);
        t3.setText(correct);





    }
}
