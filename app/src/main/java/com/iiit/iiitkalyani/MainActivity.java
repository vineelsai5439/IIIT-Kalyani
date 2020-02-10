package com.iiit.iiitkalyani;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iiit.iiitkalyani.ui.Calender.CalenderFragment;
import com.iiit.iiitkalyani.ui.gallery.GalleryFragment;
import com.iiit.iiitkalyani.ui.home.HomeFragment;
import com.iiit.iiitkalyani.ui.tools.ToolsFragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public TextView name;
    public TextView email;
    public ImageView img;
    String personName;
    String personEmail;
    Uri personPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_cal,
                R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        toolbar.setTitle("Home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                new HomeFragment()).commit();
                        break;
                    case R.id.nav_gallery:
                        toolbar.setTitle("Gallery");
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                new GalleryFragment()).commit();
                        break;
                    case R.id.nav_tools:
                        toolbar.setTitle("Fest");
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                new ToolsFragment()).commit();
                        break;
                    case R.id.nav_cal:
                        toolbar.setTitle("Academic Calender");
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                new CalenderFragment()).commit();
                        break;
                    case R.id.nav_settings:
                        Intent intent = new Intent(MainActivity.this,Settings.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(MainActivity.this, "Loged Out", Toast.LENGTH_LONG).show();
                        Intent logout = new Intent(MainActivity.this,StartActivity.class);
                        startActivity(logout);
                        finish();
                        break;
                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if (acct != null) {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            personPhoto = acct.getPhotoUrl();
        }
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        View header=navigationView.getHeaderView(0);
        name = header.findViewById(R.id.usrname);
        email = header.findViewById(R.id.usremail);
        img = header.findViewById(R.id.usrimg);
        name.setText(personName);
        email.setText(personEmail);
        Glide.with(this).load(personPhoto).circleCrop().into(img);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Loged Out", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,StartActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.action_settings) {
            Intent sett = new Intent(MainActivity.this,Settings.class);
            startActivity(sett);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}