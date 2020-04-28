package com.iiit.iiitkalyani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

import static android.widget.Toast.LENGTH_SHORT;
import static com.iiit.iiitkalyani.Settings.SHARED_PREFS;
import static com.iiit.iiitkalyani.Settings.SWITCH;
import static com.iiit.iiitkalyani.Settings.switchOn;

public class FpLogin extends AppCompatActivity {

    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private ImageView fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_login);

        fp = findViewById(R.id.fp);
        fp.setVisibility(View.INVISIBLE);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        switchOn = sharedPreferences.getBoolean(SWITCH, false);
        if (switchOn) {
            auth();
        } else {
            changeActivity();
        }
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth();
                fp.setVisibility(View.INVISIBLE);
            }
        });
        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(FpLogin.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(), "Click on FingerPrint icon to continue", LENGTH_SHORT).show();
                fp.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Authentication Successful!", LENGTH_SHORT).show();
                changeActivity();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed", LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("IIIT Kalyani")
                .setSubtitle("Authenticate to Login to IIIT Kalyani App")
                .setDeviceCredentialAllowed(true)
                .build();

    }

    private void changeActivity() {
        Intent intent = new Intent(FpLogin.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    private void auth() {
        biometricPrompt.authenticate(promptInfo);
    }
}
