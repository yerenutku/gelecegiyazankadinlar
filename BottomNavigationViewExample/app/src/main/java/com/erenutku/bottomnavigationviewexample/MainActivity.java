package com.erenutku.bottomnavigationviewexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_favorites:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fg1,BottomNavFirstMenuFragment.newInstance("1")).commit();
                        break;
                    case R.id.action_music:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fg1,BottomNavFirstMenuFragment.newInstance("2")).commit();
                        break;
                    case R.id.action_schedules:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fg1,BottomNavFirstMenuFragment.newInstance("3")).commit();
                        break;
                }

                return true;
            }
        });
    }
}
