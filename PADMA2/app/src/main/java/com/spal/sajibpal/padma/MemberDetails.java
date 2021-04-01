package com.spal.sajibpal.padma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MemberDetails extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ImageView callView,mailview;
    String text,studentname,studentdept,studentnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);

        textView=(TextView)findViewById(R.id.contract);
        callView= (ImageView) findViewById(R.id.call);
        mailview= (ImageView) findViewById(R.id.mail);

        studentname=getIntent().getStringExtra("Member");
        studentdept=getIntent().getStringExtra("dept");
        studentnumber=getIntent().getStringExtra("number");
        callView.setOnClickListener(this);
        mailview.setOnClickListener(this);

        text="Name: "+studentname+"\n"+"Dept: "+studentdept+"\n"+"Number: "+studentnumber+"\n";
        textView.setText(text);

    }

    public void onClick(View v) {

        if(v.getId()==R.id.call){

            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+studentnumber));
            startActivity(intent);
        }

        if(v.getId()==R.id.mail){

            Toast.makeText(this, "Processing", Toast.LENGTH_SHORT).show();
        }

    }
}
