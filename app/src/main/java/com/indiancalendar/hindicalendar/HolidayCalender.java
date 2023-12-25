package com.indiancalendar.hindicalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolidayCalender extends AppCompatActivity {

    WebView webView;
    public String fileName = "f0.html"; //1 jan
    public String fileName1 = "f1.html"; //2 feb
    public String fileName2 = "f2.html"; //3 mar
    public String fileName3 = "f3.html"; //4 apr
    public String fileName4 = "f4.html";//5 may
    public String fileName5 = "f5.html";//6 jun
    public String fileName6 = "f6.html";//7 july
    public String fileName7 = "f7.html";//8 aug
    public String fileName8 = "f8.html";//9 sep
    public String fileName9 = "f9.html";//10 oct
    public String fileName10 = "f91.html";//11 nov
    public String fileName11 = "f92.html";//12 dec

    private CircleImageView jan;
    private CircleImageView feb;
    private CircleImageView mar;
    private CircleImageView apr;
    private CircleImageView may;
    private CircleImageView jun;
    private CircleImageView july;
    private CircleImageView aug;
    private CircleImageView sept;
    private CircleImageView octo;
    private CircleImageView nov;
    private CircleImageView dec;
    private ProgressDialog progress;
    CountDownTimer CDT;
    int i =3;
    public void onCreate(Bundle bundle) {
        String str = "MMMM d, yyyy";
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_holiday_calender);
        webView = (WebView) findViewById(R.id.simpleWebView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        //month image name ids
        jan =(CircleImageView)findViewById(R.id.jan);
        feb =(CircleImageView)findViewById(R.id.feb);
        mar =(CircleImageView)findViewById(R.id.mar);
        apr =(CircleImageView)findViewById(R.id.april);
        may =(CircleImageView)findViewById(R.id.may);
        jun =(CircleImageView)findViewById(R.id.june);
        july =(CircleImageView)findViewById(R.id.july);
        aug =(CircleImageView)findViewById(R.id.aug);
        sept =(CircleImageView)findViewById(R.id.sept);
        octo =(CircleImageView)findViewById(R.id.oct);
        nov =(CircleImageView)findViewById(R.id.nov);
        dec =(CircleImageView)findViewById(R.id.dec);
        //close month name
        // displaying content in WebView from html file that stored in assets folder
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/festivals/" + fileName);
        webView.setBackgroundColor(0);
        //adding onclck tochangewebview
        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                webView.loadUrl("file:///android_asset/festivals/" + fileName);
            }
        });

        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName1);
            }
        });
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName2);
            }
        });
        apr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName3);
            }
        });
       may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName4);
            }
        });
       jun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName5);
            }
        });
        july.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName6);
            }
        });
        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName7);
            }
        });
        sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName8);
            }
        });
        octo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName9);
            }
        });
        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName10);
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();

                webView.loadUrl("file:///android_asset/festivals/" + fileName11);
            }
        });
    }
    public void download(){
        progress=new ProgressDialog(this);
        progress.setMessage("लोड हो रहा है ");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(i);
        progress.setCancelable(false);
        progress.show();

        CDT = new CountDownTimer(3000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                //progress.setMessage("राशिफल लोड हो रहा है.." + i + " sec");
                i--;
            }

            public void onFinish()
            {
                progress.dismiss();

            }
        }.start();
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(HolidayCalender.this);
        builder.setMessage("Back to home ");
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
}
