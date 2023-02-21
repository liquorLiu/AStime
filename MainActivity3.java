package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private TextView tet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.But_1).setOnClickListener(this);
        findViewById(R.id.But_2).setOnClickListener(this);
        findViewById(R.id.But_4).setOnClickListener(this);
        tet=findViewById(R.id.res);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.But_1)
            startActivity(new Intent(this, MainActivity.class));
        else if (v.getId() == R.id.But_2)
            startActivity(new Intent(this, MainActivity2.class));
        else if (v.getId() == R.id.But_4) {
            Intent intent =new Intent(this,Callphone.class);//新建一个意图
            Bundle bundle=new Bundle();//新建一个包裹
            bundle.putString("res",tet.getText().toString());//将tet的内容写进包裹并命名
            intent.putExtras(bundle);//将包裹放进意图
            startActivity(intent);
        }
    }


}
