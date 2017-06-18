package com.erenutku.bottomnavigationexample301;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.erenutku.bottomnavigationexample301.models.MyJsonModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    public static final String KEY_CLICK = "tiklanan";
    private BottomNavigationView mBnvMain;
    private FragmentManager mFragmentManager;
    private String myJson = "{\n" +
            "  \"cinsiyet\": true,\n" +
            "  \"yasi\": 24,\n" +
            "  \"ismi\": \"Eren Utku\"\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences("sharedpreferences_bottom", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        //region json ornegi, onemsiz
        Log.d("JSON", myJson);
        Gson gson = new GsonBuilder().create();
        MyJsonModel myJsonModel = gson.fromJson(myJson, MyJsonModel.class);
        Log.d("GSON",myJsonModel.getIsmi());
        Log.d("GSON",String.valueOf(myJsonModel.getAge()));
        Log.d("GSON",myJsonModel.isCinsiyet()+"");
        //endregion

        final FirstFragment fragment1 = FirstFragment.newInstance("Hoşgeldiniz");
        final SecondFragment secondFragment = new SecondFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();

        mBnvMain = (BottomNavigationView) findViewById(R.id.bnvMain);
        mBnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_face:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, fragment1).commit();
                        break;
                    case R.id.action_likes:
                        mFragmentManager.beginTransaction().replace(R.id.fMain, secondFragment).commit();
                        break;
                    case R.id.action_credit:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miFace:
                Toast.makeText(this, "surat", Toast.LENGTH_LONG).show();
                mEditor.putString(KEY_CLICK, "surat");
                break;
            case R.id.miLike:
                Toast.makeText(this, "kalp", Toast.LENGTH_SHORT).show();
                mEditor.putString(KEY_CLICK, "kalp");
                break;
            case R.id.miInfo:
                Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();
                mEditor.putString(KEY_CLICK, "info");
                break;
        }
        mEditor.commit();
        return super.onOptionsItemSelected(item);
    }
}
