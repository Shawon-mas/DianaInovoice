package com.dianainovoice.dianainovoice.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.dianainovoice.dianainovoice.R;


public class AccountFragment extends Fragment {
    ProgressBar progressBar_acc;

WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       ViewGroup root= (ViewGroup) inflater.inflate(R.layout.fragment_three, container, false);
        webView=root.findViewById(R.id.webview_account);
        progressBar_acc=root.findViewById(R.id.progressbar_account);

        webView.loadUrl("https://login.dianainvoice.com/login");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient( new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                progressBar_acc.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar_acc.setVisibility(View.GONE);
            }
        });

       return root;
    }
}