package com.example.introduction_to_android_part1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity2 extends AppCompatActivity {
    final RadioButton rd_add = (RadioButton) findViewById(R.id.add);
    final RadioButton rd_sub = (RadioButton) findViewById(R.id.sub);
    final RadioButton rd_mul = (RadioButton) findViewById(R.id.mul);
    final RadioButton rd_div = (RadioButton) findViewById(R.id.div);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button cal = (Button) findViewById(R.id.cal_btn);
        final EditText val1 = (EditText) findViewById(R.id.value1);
        final EditText val2 = (EditText) findViewById(R.id.value2);
        final EditText result = (EditText) findViewById(R.id.result);
        cal.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       int num1 = Integer.parseInt(val1.getText().toString());
                                       int num2 = Integer.parseInt(val2.getText().toString());
                                       String str = String.valueOf(cal(num1, num2));
                                       result.setText(str);
                                   }
            private int cal(int val1, int val2) {
                return val1 + val2;
            }
                               }
        );
        cal.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             if (!rd_add.isChecked() && !rd_sub.isChecked() && !rd_mul.isChecked()
                                                     && !rd_div.isChecked())
                                                 displayWarning();
                                             int num1 = Integer.parseInt(val1.getText().toString());
                                             int num2 = Integer.parseInt(val2.getText().toString());
                                             String str = "";
                                             if (rd_add.isChecked()) {
                                                 str = String.valueOf(cal(num1, num2, 1));
                                             }
                                             if (rd_sub.isChecked()) {
                                                 str = String.valueOf(cal(num1, num2, 2));
                                             }
                                             if (rd_mul.isChecked()) {
                                                 str = String.valueOf(cal(num1, num2, 3));
                                             }
                                             if (rd_div.isChecked()) {
                                                 str = String.valueOf(cal(num1, num2, 4));
                                             }
                                             result.setText(str);
                                         }
                                     }
        );
    }
    private int cal(int val1, int val2, int ok) {
        int result = 0;
        switch (ok) {
            case 1:
                result = val1 + val2;
                break;
            case 2:
                result = val1 - val2;
                break;
            case 3:
                result = val1 * val2;
                break;
            case 4:
                result = val1 / val2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
    private void displayWarning() {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Please choosing an operator!");
        dlgAlert.setTitle("My First App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    }

