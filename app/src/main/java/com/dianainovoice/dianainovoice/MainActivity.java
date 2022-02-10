package com.dianainovoice.dianainovoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dianainovoice.dianainovoice.Fragment.OneFragment;
import com.dianainovoice.dianainovoice.Fragment.AccountFragment;
import com.dianainovoice.dianainovoice.Fragment.HomeFragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


public class MainActivity extends AppCompatActivity {
 MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meowBottomNavigation=findViewById(R.id.bottom_nav);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.phone));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.account));
         meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
             @Override
             public void onShowItem(MeowBottomNavigation.Model item) {
                 Fragment fragment=null;
                 switch (item.getId())
                 {
                     case 1:
                         String string="8801966339900";
                         Intent intent = new Intent(Intent.ACTION_DIAL);
                         intent.setData(Uri.parse("tel:"+string));
                         startActivity(intent);
                     case 2:
                         fragment=new HomeFragment();
                         break;
                     case 3:
                         fragment=new AccountFragment();
                         break;
                 }
                     loadFragment(fragment);
             }
         });


      meowBottomNavigation.show(2,true);
      meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
          @Override
          public void onClickItem(MeowBottomNavigation.Model item) {

          }
      });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_layout,fragment)
                .commit();

    }
}
