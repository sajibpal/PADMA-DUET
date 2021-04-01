package com.spal.sajibpal.padma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class PadmaPanelOption extends AppCompatActivity {

    InterstitialAd minterstialad;
    String Psession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padma_panel_option);

        MobileAds.initialize(this,"ca-app-pub-6756845076909977~5796010484");//app id
        interstitialAdshow();
    }

    public void option(View v){

        if(v.getId()==R.id.chief){

            Intent intent=new Intent(PadmaPanelOption.this,PanelImage.class);
            intent.putExtra("option","chief");
            startActivity(intent);
        }

        else {  //for padma and coaching Pannel Member List

             Psession=getIntent().getStringExtra("Panelsession");


            if(Psession.equals("Coaching")){ //for Coaching

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent=new Intent(PadmaPanelOption.this,PannelList.class);
                            intent.putExtra("sessionyear",Psession);
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);

                        }
                    });

                } else {

                    Intent intent=new Intent(PadmaPanelOption.this,PannelList.class);
                    intent.putExtra("sessionyear",Psession);
                    startActivity(intent);

                }

            }
            else{ //for padma panel list

                Intent intent=new Intent(PadmaPanelOption.this,PannelList.class);
                intent.putExtra("sessionyear",Psession);
                startActivity(intent);

            }

        }
    }

    private void interstitialAdshow() {

        minterstialad = new InterstitialAd(this);
        minterstialad.setAdUnitId("ca-app-pub-6756845076909977/3169847146");// InterstitialAdd id
        minterstialad.loadAd(new AdRequest.Builder().build());
    }
}
