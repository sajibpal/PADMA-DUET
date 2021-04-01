package com.spal.sajibpal.padma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowNotice extends AppCompatActivity {

    TextView txtname,txttitle,txtdsk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notice);

        txtname= (TextView) findViewById(R.id.name);
        txttitle= (TextView) findViewById(R.id.title);
        txtdsk= (TextView) findViewById(R.id.dsk);

        String name=getIntent().getStringExtra("name");
        String title=getIntent().getStringExtra("title");
        String desk=getIntent().getStringExtra("desk");

        txtname.setText("Notice :"+name);
        txttitle.setText("Title :"+title);
        txtdsk.setText("Description :"+desk);
    }
}
