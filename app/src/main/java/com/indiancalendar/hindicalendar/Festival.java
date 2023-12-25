package com.indiancalendar.hindicalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ortiz.touchview.TouchImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Festival extends AppCompatActivity {

    int f43i = 0;
    int[] muhurat = {R.drawable.january_holi, R.drawable.february_holi, R.drawable.march_holi, R.drawable.april_holi, R.drawable.may_holi, R.drawable.june_holi, R.drawable.july_holi, R.drawable.august_holi, R.drawable.sepoct_holi, R.drawable.octholi, R.drawable.nov_holi, R.drawable.dec_holi};

    public TouchImageView touchImageView;
    private TextView monthTxt;
    public String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    public void onCreate(Bundle bundle) {
        String str = "MMMM d, yyyy";
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_calender_milk);
        TextView textView = (TextView) findViewById(R.id.month);
        this.monthTxt = textView;
        findViewById(R.id.btn_previous).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Festival.this.finish();
            }
        });
        try {
            Date parse = new SimpleDateFormat(str, Locale.ENGLISH).parse(new SimpleDateFormat(str, Locale.ENGLISH).format(new Date()));
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            this.f43i = instance.get(Calendar.MONTH);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        monthTxt.setText(this.month[this.f43i]);
        TouchImageView touchImageView2 = (TouchImageView) findViewById(R.id.img);
        this.touchImageView = touchImageView2;
        touchImageView2.setImageResource(this.muhurat[this.f43i]);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Festival.this.f43i < Festival.this.muhurat.length - 1) {
                    Festival.this.f43i++;
                } else {
                    Festival.this.f43i = 0;
                }
                Festival.this.touchImageView.setImageResource(Festival.this.muhurat[Festival.this.f43i]);
                Festival.this.monthTxt.setText(Festival.this.month[Festival.this.f43i]);
            }
        });
        findViewById(R.id.btn_previous).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Festival.this.f43i > 0) {
                    Festival.this.f43i--;
                } else {
                    Festival festival = Festival.this;
                    festival.f43i = festival.muhurat.length - 1;
                }
                Festival .this.touchImageView.setImageResource(Festival.this.muhurat[Festival.this.f43i]);
                Festival.this.monthTxt.setText(Festival.this.month[Festival.this.f43i]);
            }
        });
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Festival.this);
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