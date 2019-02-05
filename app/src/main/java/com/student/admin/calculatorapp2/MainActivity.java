package com.student.admin.calculatorapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b;
    String p1,p2,p3,p4,p5;
    Spinner s1;
    Calchelper1 calchelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.number1);
        ed2 = (EditText) findViewById(R.id.number2);
        ed3 = (EditText) findViewById(R.id.result);
        s1=(Spinner)findViewById(R.id.operation);
        calchelper1=new Calchelper1(this);
        calchelper1.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1 = ed1.getText().toString();
                p2 = ed2.getText().toString();
                p3 = ed3.getText().toString();
                Log.d("number1", p1);
                Log.d("number2", p2);
                Log.d("number3", p3);
                boolean status = calchelper1.insertData(p1, p2, p3);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

            }
        });
    }
}
