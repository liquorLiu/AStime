package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ShapeTest extends AppCompatActivity implements View.OnClickListener {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_test);
        findViewById(R.id.But_5).setOnClickListener(this);
        findViewById(R.id.But_6).setOnClickListener(this);
        v = findViewById(R.id.shapeT);
        v.setBackgroundResource(R.drawable.xianghezhiwu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.But_6:
                v.setBackgroundResource(R.drawable.yuanjiao);
                break;
            case R.id.But_5:
                v.setBackgroundResource(R.drawable.xianghezhiwu);
                break;

        }
    }
}