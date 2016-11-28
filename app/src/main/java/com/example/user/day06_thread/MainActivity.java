package com.example.user.day06_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt_start,bt_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_end= (Button) findViewById(R.id.button2);
        bt_start= (Button) findViewById(R.id.button1);
        //开始按钮
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SRL","程序开始");
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        delayTask();
                    }
                }.start();
                //开启新的线程去执行耗时工作
                delayTask();
            }
        });
        //结束按钮
        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SRL","程序结束");
            }
        });

    }
    //定义一个方法，做延迟处理
    private void delayTask(){
        //将执行的线程停止10秒
       for(int i=0;i<10;i++){
           try{
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           Log.e("SRL","代码执行"+Thread.currentThread()+"==="+i);
       }

    }
}
