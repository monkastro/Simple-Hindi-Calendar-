package com.indiancalendar.hindicalendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.ortiz.touchview.BuildConfig;
import com.ortiz.touchview.TouchImageView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int[] cal = { R.drawable.january_21, R.drawable.feb_21, R.drawable.march_21, R.drawable.april_21, R.drawable.may_21, R.drawable.june_21, R.drawable.july_21, R.drawable.aug_21, R.drawable.sep_21, R.drawable.oct_21, R.drawable.nov_21, R.drawable.dec_21 };
    int i = 0;
    public String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String str = "MMMM d, yyyy";
    private TextView monthTxt;
    Dialog dialog;
    ImageView img;
    TextView date;
    DrawerLayout drawerLayout;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        dialog();
        final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                .threshold(3)
                .session(4)
                .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                    @Override
                    public void onFormSubmitted(String feedback) {

                    }
                }).build();

        ratingDialog.show();
        //drawerLayout = findViewById(R.id.drawer_layout);
        //NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        TextView monthname= (TextView)findViewById(R.id.monthname);

        String string = new SimpleDateFormat("d / MMM / yyyy").format(Calendar.getInstance().getTime());
        monthname.setText(string);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
        TextView textView = (TextView) findViewById(R.id.month);
        this.monthTxt = textView;
        final TouchImageView calender_image= (TouchImageView)findViewById(R.id.calendar_img);
        findViewById(R.id.btn_previous).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
        try {
            java.util.Date parse = new SimpleDateFormat(str, Locale.ENGLISH).parse(new SimpleDateFormat(str, Locale.ENGLISH).format(new Date()));
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            this.i = instance.get(Calendar.MONTH);
        } catch (android.net.ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        calender_image.setImageResource(this.cal[this.i]);
        this.monthTxt.setText(this.month[this.i]);

        // buttons

        Button btn_next = (Button)findViewById(R.id.btn_next);
        Button btn_previous = (Button)findViewById(R.id.btn_previous);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.this.i < MainActivity.this.month.length - 1) {
                    MainActivity.this.i++;
                } else {
                    MainActivity.this.i = 0;
                }
                calender_image.setImageResource(MainActivity.this.cal[MainActivity.this.i]);
                MainActivity.this.monthTxt.setText(MainActivity.this.month[MainActivity.this.i]);

            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.this.i > 0) {
                    MainActivity.this.i--;
                } else {
                    MainActivity calendarActivity = MainActivity.this;
                    calendarActivity.i = calendarActivity.month.length - 1;
                }
                calender_image.setImageResource(MainActivity.this.cal[MainActivity.this.i]);
                MainActivity.this.monthTxt.setText(MainActivity.this.month[MainActivity.this.i]);

            }
        });

               TextView holiday_government =(TextView)findViewById(R.id.gov_holiday);
               holiday_government.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {


                      Intent intent =new Intent(MainActivity.this,HolidayCalender.class);
                      startActivity(intent);
                   }
               });

               TextView horoscope = (TextView)findViewById(R.id.horoscope);
               horoscope.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent =new Intent(MainActivity.this,Horoscope.class);
                       startActivity(intent);
                   }
               });

               TextView subh_muhurat=(TextView)findViewById(R.id.subh_muhurat);
               subh_muhurat.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent =new Intent(MainActivity.this,Vivah_Muhurt.class);
                       startActivity(intent);
                   }
               });

               TextView festival_text =(TextView)findViewById(R.id.festival_calender);
               festival_text.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent =new Intent(MainActivity.this,Festival.class);
                       startActivity(intent);
                   }
               });


        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
                if (id==R.id.rate){
                    Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(rateIntent);
                }
                if (id==R.id.suggestion){
                    Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(rateIntent);
                }
                if (id==R.id.share){
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,
                            "Hey check out this awsome calendar app: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void dialog(){
        final Dialog dialogpopup= new Dialog(this);
        dialogpopup.setContentView(R.layout.dilogebox_popup);
        img= (ImageView)dialogpopup.findViewById(R.id.imf);
        date =(TextView)dialogpopup.findViewById(R.id.date);
        String string1 = new SimpleDateFormat("d / MMM / yyyy").format(Calendar.getInstance().getTime());
        date.setText(string1);
        dialogpopup.setCancelable(false);

        dialogpopup.show();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogpopup.dismiss();
                showads();
            }
        });

        dialogpopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to exit");
        builder.setCancelable(true);
        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();



    }
    public  void showads(){
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(MainActivity
                .this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob__full_Ads));
        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial1();
            }
        });
    }
    public void displayInterstitial1() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }

    }
}
