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

public class Vivah_Muhurt extends AppCompatActivity {

    int i = 0;
    int[] muhurat = {R.drawable.jan_muhurat, R.drawable.feb_muhurat, R.drawable.march_muhurat, R.drawable.april_muhurat, R.drawable.may_muhurat, R.drawable.june_muhurat, R.drawable.july_muhurat, R.drawable.aug_muhurat, R.drawable.sep_muhurat, R.drawable.oct_muhurat, R.drawable.nov_muhurat, R.drawable.dec_muhurat};

    public TouchImageView touchImageView;
    public String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private TextView monthTxt;

    public void onCreate(Bundle bundle) {
        String str = "MMMM d, yyyy";
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_vivah__muhurt);
        TextView textView = (TextView) findViewById(R.id.month);
        this.monthTxt = textView;
        findViewById(R.id.btn_previous).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Vivah_Muhurt.this.finish();
            }
        });
        try {
            Date parse = new SimpleDateFormat(str, Locale.ENGLISH).parse(new SimpleDateFormat(str, Locale.ENGLISH).format(new Date()));
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            this.i = instance.get(Calendar.MONTH);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        monthTxt.setText(this.month[this.i]);
        TouchImageView touchImageView2 = (TouchImageView) findViewById(R.id.img);
        this.touchImageView = touchImageView2;
        touchImageView2.setImageResource(this.muhurat[this.i]);
        findViewById(R.id.btn_previous).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Vivah_Muhurt.this.i > 0) {
                    Vivah_Muhurt.this.i--;
                } else {
                    Vivah_Muhurt calendarActivity = Vivah_Muhurt.this;
                    calendarActivity.i = calendarActivity.month.length - 1;
                }
                Vivah_Muhurt.this.touchImageView.setImageResource(Vivah_Muhurt.this.muhurat[Vivah_Muhurt.this.i]);
                Vivah_Muhurt.this.monthTxt.setText(Vivah_Muhurt.this.month[Vivah_Muhurt.this.i]);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Vivah_Muhurt.this.i < Vivah_Muhurt.this.month.length - 1) {
                    Vivah_Muhurt.this.i++;
                } else {
                    Vivah_Muhurt.this.i = 0;
                }
                Vivah_Muhurt.this.touchImageView.setImageResource(Vivah_Muhurt.this.muhurat[Vivah_Muhurt.this.i]);
                Vivah_Muhurt.this.monthTxt.setText(Vivah_Muhurt.this.month[Vivah_Muhurt.this.i]);
            }
        });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Vivah_Muhurt.this);
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