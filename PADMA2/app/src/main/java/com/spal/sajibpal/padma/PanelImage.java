package com.spal.sajibpal.padma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PanelImage extends AppCompatActivity {

    ImageView imageView;
    PhotoViewAttacher attacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_image);

        String optionname=getIntent().getStringExtra("option");
        imageView= (ImageView) findViewById(R.id.image);

        if(optionname.equals("chief")){

            imageView.setImageResource(R.drawable.avdisor);
            attacher=new PhotoViewAttacher(imageView);
        }
        else{

        }

    }
}
