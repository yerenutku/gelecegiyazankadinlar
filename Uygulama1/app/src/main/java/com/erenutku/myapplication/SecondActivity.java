package com.erenutku.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private ListView lvList;
    private ArrayAdapter<String> adapter;
    private String[] ulkeler =
            {"Türkiye", "Almanya", "Avusturya", "Amerika", "İngiltere",
                    "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                    "Makedonya", "Ukrayna", "İsviçre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String email = getIntent().getStringExtra("key_email");
        getSupportActionBar().setTitle("Hoşgeldin: "+email);
        lvList = (ListView) findViewById(R.id.lvList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                alertDialog.setMessage(ulkeler[position]);
                alertDialog.setTitle(R.string.ulke_secimi);
                alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this, "evete bastın", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this, "hayıra bastın", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.show();
            }
        });
    }
}
