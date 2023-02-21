package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Callphone extends AppCompatActivity implements View.OnClickListener {

    private TextView Tex;
    private ActivityResultLauncher<Intent> intentActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callphone);
        findViewById(R.id.phone).setOnClickListener(this);

        //从上一界面传来的意图获取快递包裹
        Tex = findViewById(R.id.reqq);
        Bundle bundle=getIntent().getExtras();
        String desc=bundle.getString("res");
        Tex.setText(desc);
        //注册一个回调
        intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result!=null){
                          Intent intent = result.getData();
                            if(intent!=null&&result.getResultCode()== Activity.RESULT_OK){
                                Bundle bundle1 = intent.getExtras();
                                //取出包裹内容

                                //把返回的消息显示在一个文本上面
                            }
                    }
                });
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.phone) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:" + "17900");
            intent.setData(uri);
            startActivity(intent);
        }

    }

}