package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class PannelList extends AppCompatActivity {

    ListView vlist;
    String[] cname,deptment,number,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pannel_list);

        vlist=(ListView) findViewById(R.id.listdetail);


        String panelSession=getIntent().getStringExtra("sessionyear");

        if(panelSession.equals("2019-2020")){

            cname=getResources().getStringArray(R.array.padma1920membername);
            deptment=getResources().getStringArray(R.array.padma1920memberdept);
            number=getResources().getStringArray(R.array.padma1920membernumber);
            post=getResources().getStringArray(R.array.padma1920memberpost);
        }
        if(panelSession.equals("Coaching")){

            cname=getResources().getStringArray(R.array.coachingmembername);
            deptment=getResources().getStringArray(R.array.coachingmemberdept);
            number=getResources().getStringArray(R.array.coachingmembernumber);
            post=getResources().getStringArray(R.array.coachingmemberpost);
        }

        CustomAdapter adapter=new CustomAdapter(this,cname,post);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(PannelList.this,PanelDetails.class);
                intent.putExtra("Member",cname[position]);
                intent.putExtra("dept",deptment[position]);
                intent.putExtra("number",number[position]);
                intent.putExtra("post",post[position]);
                startActivity(intent);

            }
        });

    }
}
