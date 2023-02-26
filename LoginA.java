package com.example.dailydo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginA extends AppCompatActivity implements View.OnClickListener {

    private EditText id;
    private EditText name;
    private EditText clas;
    private EditText phone;
    private SharedPreferences mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id = findViewById(R.id.userID);
        name = findViewById(R.id.userName);
        clas = findViewById(R.id.userClass);
        phone = findViewById(R.id.userPhone);

        findViewById(R.id.userBut).setOnClickListener(this);

        mainActivity = getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        String ID = id.getText().toString();
        String NAME = name.getText().toString();
        String CLAS = clas.getText().toString();
        String PHONE = phone.getText().toString();


        SharedPreferences.Editor editor = mainActivity.edit();
        editor.putString("ID", ID);
        editor.putString("NAME", NAME);
        editor.putString("CLAS", CLAS);
        editor.putString("PHONE", PHONE);
        editor.commit();


        Intent intent = new Intent(this,MainActivity.class);
        Bundle b =new Bundle();
        b.putString("mingzi",name.getText().toString());
        intent.putExtras(b);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}