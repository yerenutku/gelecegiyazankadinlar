package com.erenutku.easynotes.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.erenutku.easynotes.R;
import com.erenutku.easynotes.models.NoteModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoteDetailsActivity extends AppCompatActivity {
    private EditText etTitle, etBody;
    private Button btSave;
    private DatabaseReference mDatabaseRoot;
    private DatabaseReference mDatabaseNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        mDatabaseRoot = FirebaseDatabase.getInstance().getReference();
        mDatabaseNotes = mDatabaseRoot.child("notes");
        initViews();
    }

    private void initViews() {
        etTitle = (EditText) findViewById(R.id.etTitle);
        etBody = (EditText) findViewById(R.id.etBody);
        btSave = (Button) findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteModel noteModel = new NoteModel(etTitle.getText().toString(), etBody.getText().toString(), false);
                mDatabaseNotes.push().setValue(noteModel);
                finish();
            }
        });
    }
}
