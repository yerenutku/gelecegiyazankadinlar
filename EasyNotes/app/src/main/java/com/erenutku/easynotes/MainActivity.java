package com.erenutku.easynotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBnvMain;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        mBnvMain = (BottomNavigationView) findViewById(R.id.bnvMain);

        final FirstFragment fragment1 = FirstFragment.newInstance("Hoşgeldiniz");
        final FirstFragment fragment2 = FirstFragment.newInstance("İkinci Fragment");
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();

        mBnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_notes:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();
                        break;
                    case R.id.action_likes:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment2).commit();
                        break;
                    case R.id.action_credit:
                        break;
                }
                return true;
            }
        });
    }
}
