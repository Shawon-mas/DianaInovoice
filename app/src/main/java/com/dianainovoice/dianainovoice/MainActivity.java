package com.dianainovoice.dianainovoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


public class MainActivity extends AppCompatActivity {
 MeowBottomNavigation meowBottomNavigation;
    WebView webView;
    ProgressBar progressBar_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview_home);
        progressBar_home=findViewById(R.id.progressbar_homeAc);
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient( new WebViewClient(){
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


        webView.loadUrl("https://dianainvoice.com/");
        meowBottomNavigation=findViewById(R.id.bottom_nav);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.phone));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.account));
         meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
             @Override
             public void onShowItem(MeowBottomNavigation.Model item) {

                 switch (item.getId())
                 {
                     case 1:
                         String string="8801966339900";
                         Intent intent = new Intent(Intent.ACTION_DIAL);
                         intent.setData(Uri.parse("tel:"+string));
                         startActivity(intent);
                         overridePendingTransition(0,0);
                         return;
                     case 2:
                         overridePendingTransition(0,0);
                        return;
                     case 3:
                        Intent intent1=new Intent(getApplicationContext(), AccountActivity.class);
                        startActivity(intent1);
                         overridePendingTransition(0,0);
                         return;
                 }

             }
         });


      meowBottomNavigation.show(2,true);
      meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
          @Override
          public void onClickItem(MeowBottomNavigation.Model item) {

          }
      });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else
            {
            super.onBackPressed();
        }

    }
}
/*
   Fragment fragment=null;
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_layout,fragment).addToBackStack(null)
                .commit();

    }
 */