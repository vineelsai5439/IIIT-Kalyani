package com.iiit.iiitkalyani;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, StartActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 100);
    }
}