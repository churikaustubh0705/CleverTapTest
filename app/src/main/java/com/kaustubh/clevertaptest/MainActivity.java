package com.kaustubh.clevertaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_push = (Button) findViewById(R.id.btn_push);

        final CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(MainActivity.this);

        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();

        profileUpdate.put("Name", "Kaustubh Churi");
        profileUpdate.put("Email", "churikaustubh@gmail.com");

        clevertapDefaultInstance.pushProfile(profileUpdate);
        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clevertapDefaultInstance.pushEvent("Product viewed");
            }
        });
    }
}
