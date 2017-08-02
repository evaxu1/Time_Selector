package com.time_selector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.feezu.liuli.timeselector.TimeSelector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取当前时间 (import  java.text.SimpleDateFormat;)
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date curDate = new Date(System.currentTimeMillis());
//        String time = formatter.format(curDate);

        TimeSelector timeSelector = new TimeSelector(MainActivity.this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();
            }
        }, "2015-01-01 00:00", "2018-12-31 23:59:59");

        //限制选择小时时段
//        TimeSelector timeSelector = new TimeSelector(MainActivity.this, new TimeSelector.ResultHandler() {
//            @Override
//            public void handle(String time) {
//                Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();
//            }
//        }, "2015-01-01 00:00", "2018-12-31 23:59:59", "9:00", "17:00");

        timeSelector.setIsLoop(false);//设置不循环,true循环

        timeSelector.setMode(TimeSelector.MODE.YMDHM);//显示 年月日时分（默认）
//        timeSelector.setMode(TimeSelector.MODE.YMD);//只显示 年月日

        timeSelector.show();
    }
}
