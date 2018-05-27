package com.example.gbv_b.lab_1_my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private boolean[] flags = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        final CheckBox checkBox1 = findViewById(R.id.checkBox);
        final CheckBox checkBox2 = findViewById(R.id.checkBox2);
        final CheckBox checkBox3 = findViewById(R.id.checkBox3);
        checkBox1.setChecked(flags[0]);
        checkBox2.setChecked(flags[1]);
        checkBox3.setChecked(flags[2]);
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
            flags[0] = checkBox1.isChecked();
            flags[1] = checkBox2.isChecked();
            flags[2] = checkBox3.isChecked();
            saveToFile();
        });
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = openFileInput("state.txt");
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                String string = new String(bytes);
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("1",string);
                startActivity(intent);
            }catch (IOException ex){
                Toast.makeText(this, "File is empty!", Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void saveToFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("state.txt", MODE_PRIVATE);
            String str = flags.toString();
            fileOutputStream.write(str.getBytes());
            Toast.makeText(this, "Save is Succesful!", Toast.LENGTH_LONG).show();
            fileOutputStream.close();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(((CheckBox) findViewById(R.id.checkBox)).getText().toString(), flags[0]);
        outState.putBoolean(((CheckBox) findViewById(R.id.checkBox2)).getText().toString(), flags[1]);
        outState.putBoolean(((CheckBox) findViewById(R.id.checkBox3)).getText().toString(), flags[2]);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("state.txt", MODE_PRIVATE);
            String str = flags.toString();
            fileOutputStream.write(str.getBytes());
            Toast.makeText(this, "Save is Succesful!", Toast.LENGTH_LONG).show();
            fileOutputStream.close();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        flags[0] = savedInstanceState.getBoolean(findViewById(R.id.checkBox).toString());
        flags[1] = savedInstanceState.getBoolean(findViewById(R.id.checkBox2).toString());
        flags[2] = savedInstanceState.getBoolean(findViewById(R.id.checkBox3).toString());
    }
}
