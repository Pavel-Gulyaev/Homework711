package com.example.homework7_1_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button syncBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        syncBtn = findViewById(R.id.syncBtn);
        syncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = syncIntent();
                startActivity(intent);
            }
        });

    }

    private Intent syncIntent(){
        int hours = currentHours();
        Intent intent = new Intent(Intent.ACTION_SYNC);
        if (hours > 5 && hours < 14) {
            intent.setData(Uri.parse("http://morning"));
        } else {
            if(hours > 13 && hours < 16) {
                intent.setData(Uri.parse("http://afternoon"));
            } else {
                intent.setData(Uri.parse("http://evening"));
            }
        }
        return intent;
    }

    private int currentHours(){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        DateFormat date = new SimpleDateFormat("HH");
        return Integer.parseInt(date.format(currentDate));
    }
}
