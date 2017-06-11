package com.erenutku.webviewkullanimi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.wvContent);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://gelecegiyazanlar.turkcell.com.tr");

        mProgressDialog = ProgressDialog.
                show(this,"Geleceği Yazan Kadınlar","Yükleniyor",true);
        mProgressDialog.show();
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT);
            }
        });
    }
}
