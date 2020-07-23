package com.example.introduction_to_android_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText EDI ;
    Button BTNP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EDI = (EditText) findViewById(R.id.EDI);
        BTNP = (Button) findViewById(R.id.BTNP);
        BTNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        nextActivity();
            }
        });
    }
    public void displayInfo(View view) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(EDI.getText().toString());
        dlgAlert.setTitle("Thông Báo:");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    public void nextActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void exitApp(View view) {
        System.exit(0);
    }
}