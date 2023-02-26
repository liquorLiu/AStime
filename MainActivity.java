package com.example.dailydo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b =getIntent().getExtras();
        String desc = b.getString("mingzi");
        TextView name=findViewById(R.id.name);
        name.setText(desc);
    }
}