package com.erenutku.customlistviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvList;
    private List<Model_Human> mHumanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList = (ListView) findViewById(R.id.lvList);

        mHumanList.add(new Model_Human(true,"Ayşe Abla"));
        mHumanList.add(new Model_Human(false,"Fatma Teyze"));
        mHumanList.add(new Model_Human(false,"Ebru"));
        mHumanList.add(new Model_Human(true,"Ebru Koşma"));
        mHumanList.add(new Model_Human(true,"Ebrucan"));
        mHumanList.add(new Model_Human(false,"Cancan"));
        mHumanList.add(new Model_Human(false,"Esma"));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this,mHumanList);
        lvList.setAdapter(customArrayAdapter);


    }
}
