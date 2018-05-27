package com.example.gbv_b.lab_1_my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        final CheckBox checkBox1 = findViewById(R.id.checkBox);
        final CheckBox checkBox2 = findViewById(R.id.checkBox2);
        final CheckBox checkBox3 = findViewById(R.id.checkBox3);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            if (checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
                Toast.makeText(this, checkBox1.getText().toString(),
                        Toast.LENGTH_LONG).show();
            } else if (checkBox2.isChecked() && !checkBox1.isChecked() && !checkBox3.isChecked()) {
                Toast.makeText(this, checkBox2.getText().toString(),
                        Toast.LENGTH_LONG).show();
            } else if (checkBox3.isChecked() && !checkBox1.isChecked() && !checkBox2.isChecked()) {
                Toast.makeText(this, checkBox3.getText().toString(),
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error! please select only one variant.",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
