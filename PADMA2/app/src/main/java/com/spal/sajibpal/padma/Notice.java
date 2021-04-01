package com.spal.sajibpal.padma;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Notice extends AppCompatActivity {

    EditText name1,age1,fulldesk;
    Button btn,btn1;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        name1= (EditText) findViewById(R.id.name);
        age1= (EditText) findViewById(R.id.age);
        fulldesk= (EditText) findViewById(R.id.fulldes);
        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.butt);

        databaseReference= FirebaseDatabase.getInstance().getReference("student");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Showdata();
            }
        });

        checkconnection();
    }

    public void SaveData(){

        String name=name1.getText().toString().trim();
        String age=age1.getText().toString().trim();
        String des=fulldesk.getText().toString().trim();

        String key=databaseReference.push().getKey();

        Student student=new Student(name,age,des);

        databaseReference.child(key).setValue(student);
        Toast.makeText(this, "Data add Sucessfully", Toast.LENGTH_SHORT).show();
        name1.setText("");
        age1.setText("");
        fulldesk.setText("");
    }

    public  void Showdata(){

        Intent intent=new Intent(Notice.this,Details.class);
        startActivity(intent);
    }

    public  boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.logout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public  boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==R.id.logout){

            SharedPreferences prf = getSharedPreferences("user_details",MODE_PRIVATE);
            Intent intent = new Intent(Notice.this,Home.class);
            SharedPreferences.Editor editor = prf.edit();
            editor.clear();
            editor.commit();
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkconnection(){

        ConnectivityManager manager= (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();

        if(null!=activeNetwork){  //if any network connection  available

            if(activeNetwork.getType()==ConnectivityManager.TYPE_WIFI){
            }
            if(activeNetwork.getType()==ConnectivityManager.TYPE_MOBILE){

            }
        }

        else{
            Toast.makeText(this, "Please Connect Your Internet", Toast.LENGTH_LONG).show();
        }
    }
}
