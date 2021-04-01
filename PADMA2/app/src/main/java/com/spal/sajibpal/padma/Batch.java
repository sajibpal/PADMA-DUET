package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Batch extends AppCompatActivity {
    ListView vlist;
    String[] coun;
    String nameoption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);

        vlist=(ListView) findViewById(R.id.list);

         nameoption=getIntent().getStringExtra("name");

        if(nameoption.equals("batch")){

            coun=getResources().getStringArray(R.array.batch);
        }
        else{

            coun=getResources().getStringArray(R.array.panelsession);
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Batch.this,R.layout.datastring,R.id.txt,coun);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(nameoption.equals("batch")){

                    Intent intent=new Intent(Batch.this,BattchDetails.class);
                    intent.putExtra("batch",coun[position]);
                    startActivity(intent);
                }
                else{

                    Intent intent=new Intent(Batch.this,PadmaPanelOption.class);
                    intent.putExtra("Panelsession",coun[position]);
                    startActivity(intent);
                }

            }
        });
    }
}
