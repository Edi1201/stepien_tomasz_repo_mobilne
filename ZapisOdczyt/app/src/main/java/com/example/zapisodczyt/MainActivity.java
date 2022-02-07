package com.example.zapisodczyt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_save = findViewById(R.id.btn_save);
        Button btn_load = findViewById(R.id.btn_load);
        EditText editTextData = findViewById(R.id.editTextData);
        TextView textViewLoad = findViewById(R.id.textViewLoad);
        Context context = this;
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "test";
                File file = new File(context.getFilesDir(), filename);
                String text = editTextData.getText().toString();
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(text);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String text = "";
                    String filename = "test";
                    File file = new File(context.getFilesDir(), filename);
                    Scanner sc = new Scanner(file);
                    while(sc.hasNext()){
                        text += sc.nextLine();
                    }
                    textViewLoad.setText(text);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}