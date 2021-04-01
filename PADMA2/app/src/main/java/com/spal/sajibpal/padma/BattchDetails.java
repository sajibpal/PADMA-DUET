package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class BattchDetails extends AppCompatActivity {

    ListView vlist;
    String[] cname,deptment,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battch_details);

        vlist=(ListView) findViewById(R.id.listdetail);



        String batchname=getIntent().getStringExtra("batch");

        if(batchname.equals("23th Batch")){

            cname=getResources().getStringArray(R.array.batch23name);
            deptment=getResources().getStringArray(R.array.batch23department);
            number=getResources().getStringArray(R.array.batch23number);
        }
       else if(batchname.equals("24th Batch")){

            cname=getResources().getStringArray(R.array.batch24name);
            deptment=getResources().getStringArray(R.array.batch24department);
            number=getResources().getStringArray(R.array.batch24number);
        }
        else if(batchname.equals("25th Batch")){
            cname=getResources().getStringArray(R.array.batch25name);
            deptment=getResources().getStringArray(R.array.batch25department);
            number=getResources().getStringArray(R.array.batch25number);
        }
        else  if(batchname.equals("26th Batch")){

            cname=getResources().getStringArray(R.array.batch26name);
            deptment=getResources().getStringArray(R.array.batch26department);
            number=getResources().getStringArray(R.array.batch26number);
        }
        else if(batchname.equals("27th Batch")){

            cname=getResources().getStringArray(R.array.batch27name);
            deptment=getResources().getStringArray(R.array.batch27department);
            number=getResources().getStringArray(R.array.batch27number);
        }

        else if(batchname.equals("29th Batch")){

            cname=getResources().getStringArray(R.array.batch29name);
            deptment=getResources().getStringArray(R.array.batch29department);
            number=getResources().getStringArray(R.array.batch29number);
        }
        else if(batchname.equals("30th Batch")){

            cname=getResources().getStringArray(R.array.batch30name);
            deptment=getResources().getStringArray(R.array.batch30department);
            number=getResources().getStringArray(R.array.batch30number);
        }
        else if(batchname.equals("31th Batch")){

            cname=getResources().getStringArray(R.array.batch31name);
            deptment=getResources().getStringArray(R.array.batch31department);
            number=getResources().getStringArray(R.array.batch31number);
        }
        else if(batchname.equals("32th Batch")){

            cname=getResources().getStringArray(R.array.batch32name);
            deptment=getResources().getStringArray(R.array.batch32department);
            number=getResources().getStringArray(R.array.batch32number);
        }
        else{

            cname=getResources().getStringArray(R.array.batch33name);
            deptment=getResources().getStringArray(R.array.batch33department);
            number=getResources().getStringArray(R.array.batch33number);
        }

        CustomAdapter adapter=new CustomAdapter(this,cname,deptment);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(BattchDetails.this,MemberDetails.class);
                intent.putExtra("Member",cname[position]);
                intent.putExtra("dept",deptment[position]);
                intent.putExtra("number",number[position]);
                startActivity(intent);

            }
        });
    }
}
