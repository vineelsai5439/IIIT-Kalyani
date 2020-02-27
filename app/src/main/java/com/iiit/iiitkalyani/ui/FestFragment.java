package com.iiit.iiitkalyani.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.iiit.iiitkalyani.R;


public class FestFragment extends Fragment {

    private WebView WebView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        WebView = root.findViewById(R.id.web);
        WebView.setWebViewClient(new WebViewClient());
        WebView.loadUrl("https://gauravanand563.github.io/iiitkfest/");
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.canGoBack();
        WebView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && WebView.canGoBack()) {
                    WebView.goBack();
                    return true;
                }
                return false;
            }
        });
        return root;

    }
}