package com.spal.sajibpal.padma;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewImageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private ProgressBar progressBar;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        checkconnection();

        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar= (ProgressBar) findViewById(R.id.progress_circular);

        mUploads=new ArrayList<>();
        mDatabaseRef=FirebaseDatabase.getInstance().getReference("uploads");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
               {
                   Upload upload=postSnapshot.getValue(Upload.class);
                   mUploads.add(upload);
               }
               mAdapter=new ImageAdapter(ViewImageActivity.this, mUploads);
               mRecyclerView.setAdapter(mAdapter);
               progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewImageActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
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
