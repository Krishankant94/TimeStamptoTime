package com.example.krishan.timestamptotime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    EditText et_timestamp;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_timestamp = (EditText) findViewById(R.id.et_timestamp);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    public void getValue(View view) {
        String timestamp = et_timestamp.getText().toString();
        String result = getConvertedTime(timestamp);
        tv_result.setText(result);
    }

    private String getConvertedTime(String timestamp) {
        long unixSeconds = Long.parseLong(timestamp);
// convert seconds to milliseconds
        Date date = new Date(unixSeconds * 1000L);
// the format of your date
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
// give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
