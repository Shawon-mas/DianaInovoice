package com.dianainovoice.dianainovoice.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.dianainovoice.dianainovoice.R;


public class HomeFragment extends Fragment {
    WebView webView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.fragment_two, container, false);
        webView=root.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("https://dianainvoice.com/");
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                  if(keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                      if(i==KeyEvent.KEYCODE_BACK){
                          if(webView!=null){
                              if(webView.canGoBack()){
                                  webView.goBack();
                              } else {
                                  getActivity().onBackPressed();
                              }
                          }
                      }
                  }
                return true;
            }
        });
        return root;

    }

}
/*

 webView.setWebViewClient( new WebViewClient(){
           @Override
           public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
               return true;
           }

           @Override
           public void onPageStarted(WebView view, String url, Bitmap favicon) {
               super.onPageStarted(view, url, favicon);

               progressBar_home.setVisibility(View.VISIBLE);
           }

           @Override
           public void onPageFinished(WebView view, String url) {
               super.onPageFinished(view, url);

               progressBar_home.setVisibility(View.GONE);
           }
       });

        <ProgressBar
        android:id="@+id/progressbar_account"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="@style/Widget.AppCompat.ProgressBar.Horizontal"
        android:indeterminate="true"
        />

          progressBar_home=root.findViewById(R.id.progressbar);
 ProgressBar progressBar_home;


        webSettings.setDomStorageEnabled(true);
        //enabling javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //database enabled
        webSettings.setDatabaseEnabled(true);

 */
