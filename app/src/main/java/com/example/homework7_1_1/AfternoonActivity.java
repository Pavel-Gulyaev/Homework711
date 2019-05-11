package com.example.homework7_1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AfternoonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        DateFormat date = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String time = date.format(currentDate);
        TextView timeText = findViewById(R.id.time);
        timeText.setText(time);
    }
}
