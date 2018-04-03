package com.example.ankita.nodeappandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PostActivity extends AppCompatActivity {

    Spinner  s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        s = (Spinner)findViewById(R.id.spinner);
        String[] item = new String[]{"AC Repair","Carpenter","Electrician","Mechanic","Pest Control","Plumber","Wall Painter"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this,R.layout.dropdown,item);
        s.setAdapter(ad);

    }
}
