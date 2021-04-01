package com.spal.sajibpal.padma;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowNotification extends AppCompatActivity {

    TextView txt;
    private Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        txt= (TextView) findViewById(R.id.text);

        if(getIntent().getExtras()!=null){

            String message=getIntent().getStringExtra("msg");
            txt.setText(message);
        }

    }
}
