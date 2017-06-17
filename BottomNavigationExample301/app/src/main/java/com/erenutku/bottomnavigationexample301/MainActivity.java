package com.erenutku.bottomnavigationexample301;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    public static final String KEY_CLICK = "tiklanan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences("sharedpreferences_bottom", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        TextView mTextView = (TextView) findViewById(R.id.tvLastClick);

        mTextView.setText(mSharedPreferences.getString(KEY_CLICK, "henüz atama yapılmamış"));
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
