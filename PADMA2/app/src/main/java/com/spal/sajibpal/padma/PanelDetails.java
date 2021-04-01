package com.spal.sajibpal.padma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PanelDetails extends AppCompatActivity implements View.OnClickListener  {


    TextView textView,texttitle;
    ImageView callView,mailview;
    String text,postname,postdept,postnumber,posttitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);

        textView=(TextView)findViewById(R.id.contract);
        texttitle=(TextView)findViewById(R.id.paneltitle);
        callView= (ImageView) findViewById(R.id.call);
        mailview= (ImageView) findViewById(R.id.mail);

        callView.setOnClickListener(this);
        mailview.setOnClickListener(this);

        postname=getIntent().getStringExtra("Member");
        postdept=getIntent().getStringExtra("dept");
        postnumber=getIntent().getStringExtra("number");
        posttitle=getIntent().getStringExtra("post");


        text="Name: "+postname+"\n"+"Dept: "+postdept+"\n"+"Number: "+postnumber+"\n";
        textView.setText(text);
        texttitle.setText(posttitle);

    }

    public void onClick(View v) {

        if(v.getId()==R.id.call){

            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+postnumber));
            startActivity(intent);
        }

        if(v.getId()==R.id.mail){

            Toast.makeText(this, "Processing", Toast.LENGTH_SHORT).show();
        }

    }
}
