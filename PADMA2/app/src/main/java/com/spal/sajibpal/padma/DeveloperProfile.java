package com.spal.sajibpal.padma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DeveloperProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_profile);

    }

    public  void show(View v){

        if(v.getId()==R.id.email){

            Intent intent=new Intent(DeveloperProfile.this,Mail.class);
            intent.putExtra("mail","sajib");
            startActivity(intent);

        }
       else if(v.getId()==R.id.mobile){

            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+"+8801926101829"));
            startActivity(intent);
        }
       else {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sajib.pal.121"));
            startActivity(intent);
        }

    }
}
