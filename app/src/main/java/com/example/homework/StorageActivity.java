package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity implements View.OnClickListener {
    // declare the variables
    Button read, write;
    EditText userInput, passwordInput;
    TextView fileContent;

    private String filename = "demoFile.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        read = findViewById(R.id.btnRead);
        write = findViewById(R.id.btnWrite);
        userInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        fileContent = findViewById(R.id.fileContent);

        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    public void printMessage(String m) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        // get the button text : in out case either read or
        // write depending on the button pressed.
        String b_text = b.getText().toString();

        switch (b_text.toLowerCase()) {
            case "write information": {
                writeData();
                break;
            }
            case "read information": {
                readData();
                break;
            }
        }
    }

    private void writeData() {
        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE); //MODE_APPEND or MODE_PRIVATE.
            String data = userInput.getText().toString();
            data += "\n";
            data += passwordInput.getText().toString();

            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInput.setText("");
        passwordInput.setText("");
        printMessage("writing to file " + filename + " ...");
    }


    private void readData() {
        try {
            FileInputStream fin = openFileInput(filename);
            int a;
            StringBuilder temp = new StringBuilder();
            while ((a = fin.read()) != -1) {
                temp.append((char) a);
            }

            String[] words = temp.toString().split("\n");

            // setting text from the file.
            userInput.setText(words[0]);
            passwordInput.setText(words[1]);
            fileContent.setText(temp.toString());
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printMessage("reading to file " + filename + " completed..");
    }
}