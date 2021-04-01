package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Spnas extends AppCompatActivity {

    ProgressBar bar;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spnas);

        bar=(ProgressBar) findViewById(R.id.proge);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                work();
                next();
            }
        });
        thread.start();
    }

    public  void  work(){

        for(val=1;val<=100;val+=1) {

            try{

                bar.setProgress(val);
                Thread.sleep(60);

            }catch (Exception j){


            }
        }

    }
    public  void next(){

        Intent intent=new Intent(Spnas.this,Home.class);
        startActivity(intent);
        finish();
    }
}
