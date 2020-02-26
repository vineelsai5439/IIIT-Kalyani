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

    private WebView mWebView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        mWebView = root.findViewById(R.id.web);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://gauravanand563.github.io/iiitkfest/");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });
        return root;

    }
}