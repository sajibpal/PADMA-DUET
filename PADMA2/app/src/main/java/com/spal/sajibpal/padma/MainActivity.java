package com.spal.sajibpal.padma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        uname = (EditText) findViewById(R.id.txtName);
        pwd = (EditText) findViewById(R.id.txtPwd);
        loginBtn = (Button) findViewById(R.id.btnLogin);
        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        if(getIntent().getExtras()!=null){

            if (pref.contains("username") && pref.contains("password")) {
                Intent intent = new Intent(MainActivity.this,Notice.class);
                startActivity(intent);
                finish();
            }
        }
        else{

            if (pref.contains("username") && pref.contains("password")) {
                Intent intent = new Intent(MainActivity.this,ImageGallery.class);
                startActivity(intent);
                finish();
            }
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                if (username.equals("padma") && password.equals("padma.duet")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    if(getIntent().getExtras()!=null){

                        Intent intent = new Intent(MainActivity.this,Notice.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this,ImageGallery.class);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Username or Password are not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

