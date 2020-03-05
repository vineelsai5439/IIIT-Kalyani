package com.iiit.iiitkalyani;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settings extends AppCompatActivity {
    String personName;
    String personEmail;
    Uri personPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        TextView name = findViewById(R.id.txtName);
        CircleImageView profileimg = findViewById(R.id.Profile_image);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Settings.this);
        if (acct != null) {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            personPhoto = acct.getPhotoUrl();
        }else {
            personName = Objects.requireNonNull(auth.getCurrentUser()).getDisplayName();
            personPhoto = auth.getCurrentUser().getPhotoUrl();
            personEmail = auth.getCurrentUser().getEmail();
        }
        name.setText(personName);
        Picasso.get().load(personPhoto).into(profileimg);
    }
}
