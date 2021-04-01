package com.spal.sajibpal.padma;



import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    ListView listView;
    DatabaseReference dataReference;
    List<Student> studentList1;
    CustomAdap adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dataReference= FirebaseDatabase.getInstance().getReference("student");
        studentList1=new ArrayList<>();
        adapter=new CustomAdap(Details.this,studentList1);

        listView= (ListView)findViewById(R.id.list);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student selecteditem = studentList1.get(position);
                final String key=selecteditem.getKey();
                showUpdateDeleteDialog(key,selecteditem.getAge(), selecteditem.getName(),selecteditem.getDsk());
                return true;

            }
        });
    }

    @Override
    protected void onStart() {

        dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                studentList1.clear();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Student student=dataSnapshot1.getValue(Student.class);
                    student.setKey(dataSnapshot1.getKey());
                    studentList1.add(student);
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(Details.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
        super.onStart();
    }

//update and delete dialog

    private void showUpdateDeleteDialog(final String keyid ,String age, String name,String desk) {


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.updatedata, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.name);
        final EditText editTextage = (EditText) dialogView.findViewById(R.id.age);
        final EditText editTextdesk = (EditText) dialogView.findViewById(R.id.dsk);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.update);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.delete);

        editTextage.setText(age);
        editTextName.setText(name);
        editTextdesk.setText(desk);

        dialogBuilder.setTitle(name);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String age =editTextage.getText().toString().trim();
                String desks =editTextdesk.getText().toString().trim();

                if (!name.isEmpty()) {
                    updateArtist(keyid ,name, age,desks);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteArtist(keyid);
                b.dismiss();

            }
        });
    }

 //update methode

    private boolean updateArtist(String id,String name, String age,String desk) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("student").child(id);

        //updating artist
        Student artist = new Student(name,age,desk);
        dR.setValue(artist);
        Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    //Delete methode

    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("student").child(id);

        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_LONG).show();
        return true;
    }
}
