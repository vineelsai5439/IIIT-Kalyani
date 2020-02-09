package com.iiit.iiitkalyani;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Blog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Blog.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
