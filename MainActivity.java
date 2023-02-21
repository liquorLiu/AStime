package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.tv);
        t.setText("尚未点击按钮");
        findViewById(R.id.but_back).setOnClickListener(this);
        Button but=findViewById(R.id.but);
        but.setOnClickListener(new MyOnClickListener(t));
        Button butt=findViewById(R.id.butt);
        butt.setOnClickListener(this);
        Button longb=findViewById(R.id.longb);
        //匿名内部类
        longb.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String a="你长按了这个按钮";
                t.setText(a);
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        String a;
        if(view.getId()==R.id.butt) {
            a = "这里是正序显示";
            t.setText(a);
        }
        else if(view.getId()==R.id.but_back){
            finish();
        }
    }

    static class MyOnClickListener implements View.OnClickListener{
        private final TextView t;

        public MyOnClickListener(TextView t) {
            this.t=t;
        }

        @Override
        public void onClick(View view){
            String a="示显序倒是里这";
            t.setText(a);

        }

    }


}