package com.indiancalendar.hindicalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import de.hdodenhof.circleimageview.CircleImageView;

public class Horoscope extends AppCompatActivity {
    WebView webView;
    public String fileName = "mesh.html"; //1 singh rashi
    public String fileName1 = "vrishab.html"; //2 vrishich rashi
    public String fileName2 = "mithun.html"; //3 mithun rashi
    public String fileName3 = "kark.html"; //4 krk rashi
    public String fileName4 = "leo.html";//5 singhrashi
    public String fileName5 = "kanya.html";//6 kanya rashi
    public String fileName6 = "tula.html";//7 tula rashi
    public String fileName7 = "vrishic.html";//8 vrischi rshi
    public String fileName8 = "dhanurashi.html";//9 dhanu rashi
    public String fileName9 = "makarrashi.html";//10 makar rashi
    public String fileName10 = "kumbhrashi.html";//11kumbhrashi
    public String fileName11 = "minrashi.html";//12 min rashi
    private CircleImageView meshrashi;
    private InterstitialAd interstitial;
    private CircleImageView vrishabrashi;
    private CircleImageView mithunrashi;
    private CircleImageView karkrashi;
    private CircleImageView singhrashi;
    private CircleImageView kanyarashi;
    private CircleImageView tularashi;
    private CircleImageView vrishicrashi;
    private CircleImageView dhanurashi;
    private CircleImageView makarrashi;
    private CircleImageView kumbhrashi;
    private CircleImageView minrashi;
    private ProgressDialog progress;
    CountDownTimer CDT;
    int i =3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        // init webView
        webView = (WebView) findViewById(R.id.simpleWebView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        //webView.setText(Color.parseColor("#919191"));
        //rashi image name ids
        meshrashi =(CircleImageView)findViewById(R.id.mesh_rashi);
        vrishabrashi =(CircleImageView)findViewById(R.id.vrishb_rashi);
        mithunrashi =(CircleImageView)findViewById(R.id.mithun_rashi);
        karkrashi =(CircleImageView)findViewById(R.id.krk_rashi);
        singhrashi =(CircleImageView)findViewById(R.id.singh_rashi);
        kanyarashi =(CircleImageView)findViewById(R.id.kanya_rashi);
        tularashi =(CircleImageView)findViewById(R.id.tula_rashi);
        vrishicrashi =(CircleImageView)findViewById(R.id.vrishic_rashi);
        dhanurashi =(CircleImageView)findViewById(R.id.dhanu_rashi);
        makarrashi =(CircleImageView)findViewById(R.id.makar_rashi);
        kumbhrashi =(CircleImageView)findViewById(R.id.kumbh_rashi);
        minrashi =(CircleImageView)findViewById(R.id.min_rashi);
        //close rashi name
        // displaying content in WebView from html file that stored in assets folder
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
        //adding onclck tochangewebview
        meshrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                meshrashi.setImageResource(R.drawable.aries_sym);
                webView.loadUrl("file:///android_asset/" + fileName);
            }
        });

        vrishabrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                vrishabrashi.setImageResource(R.drawable.taurus_sym);
                webView.loadUrl("file:///android_asset/" + fileName1);
            }
        });
        mithunrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                mithunrashi.setImageResource(R.drawable.gemini_sym);
                webView.loadUrl("file:///android_asset/" + fileName2);
            }
        });
        karkrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                karkrashi.setImageResource(R.drawable.cancer_sym);
                webView.loadUrl("file:///android_asset/" + fileName3);
            }
        });
        singhrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                singhrashi.setImageResource(R.drawable.leo_sym);
                webView.loadUrl("file:///android_asset/" + fileName4);
            }
        });
        kanyarashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                kanyarashi.setImageResource(R.drawable.virgo_sym);
                webView.loadUrl("file:///android_asset/" + fileName5);
            }
        });
        tularashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                tularashi.setImageResource(R.drawable.libra_sym);
                webView.loadUrl("file:///android_asset/" + fileName6);
            }
        });
        vrishicrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                vrishicrashi.setImageResource(R.drawable.scorpio_sym);
                webView.loadUrl("file:///android_asset/" + fileName7);
            }
        });
        dhanurashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                dhanurashi.setImageResource(R.drawable.sagittarius_sym);
                webView.loadUrl("file:///android_asset/" + fileName8);
            }
        });
        makarrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                makarrashi.setImageResource(R.drawable.capricornus_sym);
                webView.loadUrl("file:///android_asset/" + fileName9);
            }
        });
        kumbhrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                kumbhrashi.setImageResource(R.drawable.aquarius_sym);
                webView.loadUrl("file:///android_asset/" + fileName10);
            }
        });
        minrashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                minrashi.setImageResource(R.drawable.pisces_sym);
                webView.loadUrl("file:///android_asset/" + fileName11);
            }
        });
    }
    public void download(){
        progress=new ProgressDialog(this);
        progress.setMessage("राशिफल लोड हो रहा है ");
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

        showads();

        final AlertDialog.Builder builder = new AlertDialog.Builder(Horoscope.this);
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
    public  void showads(){
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(Horoscope.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob__full_horoscope));
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
