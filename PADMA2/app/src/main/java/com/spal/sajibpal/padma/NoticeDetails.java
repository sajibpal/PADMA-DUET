package com.spal.sajibpal.padma;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;


public class NoticeDetails extends AppCompatActivity {

    ListView listView;
    DatabaseReference dataReference;
    List<Student> studentList1;
    CustomAdap adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_details);

        dataReference = FirebaseDatabase.getInstance().getReference("student");
        studentList1 = new ArrayList<>();
        adapter = new CustomAdap(NoticeDetails.this, studentList1);
        listView = (ListView) findViewById(R.id.list1);

        checkconnection();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Student selecteditem = studentList1.get(position);
                Intent intent=new Intent(NoticeDetails.this,ShowNotice.class);
                intent.putExtra("name",selecteditem.getName());
                intent.putExtra("title",selecteditem.getAge());
                intent.putExtra("desk",selecteditem.getDsk());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {

        dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                studentList1.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    Student student = dataSnapshot1.getValue(Student.class);
                    student.setKey(dataSnapshot1.getKey());
                    studentList1.add(student);
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(NoticeDetails.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
        super.onStart();
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