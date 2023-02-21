package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView out;
    private String fir = "";//数1
    private String ope = "";//运算符
    private String sec = "";//数2
    private String now = "";//展示
    private String last = "";//结果

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main2);
        //获取关键文本视图 ctrl alt f
        out = findViewById(R.id.putout);
        //给按钮监听器
        findViewById(R.id.aa).setOnClickListener(this);
        findViewById(R.id.ab).setOnClickListener(this);
        findViewById(R.id.ac).setOnClickListener(this);
        findViewById(R.id.ad).setOnClickListener(this);
        findViewById(R.id.ba).setOnClickListener(this);
        findViewById(R.id.bb).setOnClickListener(this);
        findViewById(R.id.bc).setOnClickListener(this);
        findViewById(R.id.bd).setOnClickListener(this);
        findViewById(R.id.ca).setOnClickListener(this);
        findViewById(R.id.cb).setOnClickListener(this);
        findViewById(R.id.cc).setOnClickListener(this);
        findViewById(R.id.cd).setOnClickListener(this);
        findViewById(R.id.da).setOnClickListener(this);
        findViewById(R.id.db).setOnClickListener(this);
        findViewById(R.id.dc).setOnClickListener(this);
        findViewById(R.id.dd).setOnClickListener(this);
        findViewById(R.id.ea).setOnClickListener(this);
        findViewById(R.id.eb).setOnClickListener(this);
        findViewById(R.id.ec).setOnClickListener(this);
        findViewById(R.id.ed).setOnClickListener(this);
        findViewById(R.id.but_back2).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        String input;
        if (view.getId() == R.id.dd) {//特殊的那个开根号
            input = "√";
        } else {
            input = ((TextView) view).getText().toString();
        }
        switch (view.getId()) {

            case R.id.aa:

            case R.id.ad:
                cleanly();
                break;
            case R.id.ab://除号
            case R.id.ac://cheng号
            case R.id.bd://jia号
            case R.id.cd://-号
                ope = input;
                refresh(now + ope);
                break;
            case R.id.ed://=号
                int cla = cla();
                refreshope(String.valueOf(cla));
                refresh(now + "=" + last);
                break;
            case R.id.dd://gen号
                double cla2 = Math.sqrt(Double.parseDouble(fir));
                refreshope(String.valueOf(cla2));
                refresh(now + "√=" + last);
                break;
            case R.id.ea://dao数
                break;
            default:
                if (last.length() > 0 && ope.equals("")) {
                    cleanly();
                }
                if (ope.equals(""))
                    fir = fir + input;
                else
                    sec = sec + input;
                if (now.equals("0") && !input.equals(".")) {
                    refresh(input);
                }
                refresh(now + input);
                break;

        } if (view.getId() == R.id.but_back2) {
            finish();
        }
    }

    //清屏
    private void cleanly() {
        refreshope("");
        refresh("");
    }

    //进行计算
    private int cla() {
        switch (ope) {
            case "+":
                return Integer.parseInt(fir) + Integer.parseInt(sec);
            case "-":
                return Integer.parseInt(fir) - Integer.parseInt(sec);
            case "X":
                return Integer.parseInt(fir) * Integer.parseInt(sec);
            default:
                return Integer.parseInt(fir) / Integer.parseInt(sec);

        }
    }

    //在运算结束后对操作数进行刷新
    private void refreshope(String newres) {
        last = newres;
        fir = last;
        sec = "";
        ope = "";
    }

    //根据监听器得到的结果对屏幕进行适时刷新
    private void refresh(String text) {
        now = text;
        out.setText(now);
    }
}
