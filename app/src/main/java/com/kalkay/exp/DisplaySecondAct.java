package com.kalkay.exp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DisplaySecondAct extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_act);

        webview = (WebView) findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient());
//        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("https://en.wikipedia.org/wiki/Pulp_Fiction");
    }

}
