package com.example.gbv_b.lab_1_my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView1 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button3);
        textView1.setText(getIntent().getStringExtra("1"));
        button.setOnClickListener(v ->{
            finish();
        });
    }
}
