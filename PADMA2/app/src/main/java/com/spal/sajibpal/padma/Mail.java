package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mail extends AppCompatActivity {

    Button btn,btn1;
    EditText txt,txt1;
    String mailuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        btn=(Button) findViewById(R.id.button);
        btn1=(Button) findViewById(R.id.button1);
        txt=(EditText) findViewById(R.id.text);
        txt1=(EditText) findViewById(R.id.text1);

         mailuser=getIntent().getStringExtra("mail");
    }

    public  void show(View v){
        try{
            String name=txt.getText().toString();
            String message=txt1.getText().toString();

            if(v.getId()==R.id.button){



                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/mail");
               if(mailuser.equals("sajib")){

                   intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"sajibpal20@gmail.com"});
               }

               else{
                   intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"duet.padma@gmail.com"});
               }

                intent.putExtra(Intent.EXTRA_SUBJECT,"Mail from app user");
                intent.putExtra(Intent.EXTRA_TEXT,"name : "+name +"\nMessage : "+message);
                startActivity(intent.createChooser(intent,"Send Mail"));
            }
            if(v.getId()==R.id.button1){

                txt.setText("");
                txt1.setText("");
            }
        }
        catch (Exception e){

            Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }

    }
}
