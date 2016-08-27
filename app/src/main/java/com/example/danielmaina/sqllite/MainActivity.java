package com.example.danielmaina.sqllite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText myEditext = (EditText) findViewById(R.id.myEditText);
        TextView myTextView = (TextView) findViewById(R.id.myTextView);

       MyDBHandler dbHandler = new MyDBHandler(this, null,null, 1);
    }
}
