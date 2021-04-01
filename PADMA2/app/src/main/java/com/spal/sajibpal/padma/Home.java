package com.spal.sajibpal.padma;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CardView  galleryview,memberview,padmaview,coachingview,panelbaniview,noticeview;
    InterstitialAd minterstialad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MobileAds.initialize(this,"ca-app-pub-6756845076909977~5796010484");//app id
        interstitialAdshow();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


         galleryview= (CardView) findViewById(R.id.gallery);
         memberview= (CardView) findViewById(R.id.memberId);
         padmaview= (CardView) findViewById(R.id.padmapanel);
         coachingview= (CardView) findViewById(R.id.coaching);
         panelbaniview= (CardView) findViewById(R.id.notice);
         noticeview= (CardView) findViewById(R.id.notifi);


        galleryview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(Home.this, ViewImageActivity.class);
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);
                        }
                    });

                } else {

                    Intent intent = new Intent(Home.this, ViewImageActivity.class);
                    startActivity(intent);

                }

            }
        });

        memberview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for Member List
                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent =new Intent(Home.this,Batch.class);
                            intent.putExtra("name","batch");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);

                        }
                    });

                } else {

                    startActivity(new Intent(Home.this,Batch.class).putExtra("name","batch"));

                }

            }
        });

        padmaview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //for Padma

                if (minterstialad.isLoaded()) {

                    minterstialad.show();

                    minterstialad.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent =new Intent(Home.this,Batch.class);
                            intent.putExtra("name","panelOption");
                            minterstialad.loadAd(new AdRequest.Builder().build());
                            startActivity(intent);

                        }
                    });

                } else {

                    startActivity(new Intent(Home.this,Batch.class).putExtra("name","panelOption"));

                }

            }
        });
        coachingview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for coaching

                startActivity(new Intent(Home.this,PadmaPanelOption.class).putExtra("Panelsession","Coaching"));
            }
        });
        panelbaniview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for panelbani

                startActivity(new Intent(Home.this,Padmabanni.class));
            }
        });
        noticeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for notice

                startActivity(new Intent(Home.this,NoticeDetails.class));
            }
        });

    }

   private void interstitialAdshow() {

        minterstialad = new InterstitialAd(this);
        minterstialad.setAdUnitId("ca-app-pub-6756845076909977/3169847146");// InterstitialAdd id
        minterstialad.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


      if (id == R.id.notices) {

           startActivity(new Intent(Home.this,MainActivity.class).putExtra("notice","NoticeActivity"));
        }
        else  if (id == R.id.back) {

            startActivity(new Intent(Home.this,Mail.class).putExtra("mail","sajib"));
        }
        else  if (id == R.id.imageupload) {

            startActivity(new Intent(Home.this,MainActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

          if (id == R.id.nav_page) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Padma.duet/"));
            startActivity(intent);

         }
        else if (id == R.id.nav_mail) {

              Intent intent=new Intent(Home.this,Mail.class);
              intent.putExtra("mail","padma");
              startActivity(intent);
        }
        else if (id == R.id.nav_phone) {

              Intent intent=new Intent(Intent.ACTION_DIAL);
              intent.setData(Uri.parse("tel:"+"+8801889710002"));
              startActivity(intent);

          }
      else if (id == R.id.developer) {

            startActivity(new Intent(Home.this,DeveloperProfile.class));
        }

          else{
                  Intent smsintent=new Intent(Intent.ACTION_VIEW);
                  smsintent.setData(Uri.parse("smsto:"));
                  smsintent.setType("vnd.android-dir/mms-sms");
                  smsintent.putExtra("address",new String("+8801889710002"));
                  smsintent.putExtra("sms_body","PADMA");

                  try {
                      startActivity(smsintent);
                      Log.i("Finished sending SMS...", "");
                  } catch (android.content.ActivityNotFoundException ex) {
                      Toast.makeText(Home.this, "SMS failed, please try again later.", Toast.LENGTH_SHORT).show();
                  }

          }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
