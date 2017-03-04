package com.bawei.yuanxingjindutiao2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;
    private int count=360;
    private int mcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        myView = (MyView) findViewById(R.id.myView);

        //开启子线程
        startThrend();
    }

    private void startThrend() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                while(mcount<=count){
                    mcount++;
                    myView.addrest(count,mcount);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
