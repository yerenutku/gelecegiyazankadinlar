package com.erenutku.easynotes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.erenutku.easynotes.activity.NoteDetailsActivity;
import com.erenutku.easynotes.adapter.NotesAdapter;
import com.erenutku.easynotes.model.NoteModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private String text;
    private ListView lvNotes;
    private NotesAdapter mNotesAdapter;
    private ArrayList<NoteModel> mNoteList = new ArrayList<>();
    private DatabaseReference mDatabaseRoot;

    private static FirstFragment mFirstFragment;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String text){
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.text = text;
        return firstFragment;
    }
    //singleton yapısı
    public static FirstFragment getInstance(){
        if (mFirstFragment == null){
            mFirstFragment = new FirstFragment();
        }
        return mFirstFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        textView.setText(text);
        lvNotes = (ListView) view.findViewById(R.id.lvNotes);
        mNotesAdapter = new NotesAdapter(getContext(),mNoteList);
        lvNotes.setAdapter(mNotesAdapter);
        mNoteList.clear();
        mDatabaseRoot = FirebaseDatabase.getInstance().getReference();
        mDatabaseRoot.child("notes").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                NoteModel noteModel = dataSnapshot.getValue(NoteModel.class);
                mNoteList.add(noteModel);
                mNotesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                NoteModel noteModel = dataSnapshot.getValue(NoteModel.class);
                for (NoteModel note: mNoteList){
                    if (note.getKey().equals(noteModel.getKey())){
                        note.setTitle(noteModel.getTitle());
                        note.setBody(noteModel.getBody());
                        note.setFavorite(noteModel.isFavorite());
                        mNotesAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(),NoteDetailsActivity.class);
                intent.putExtra(NoteDetailsActivity.EXTRA_TITLE,mNoteList.get(position).getTitle());
                intent.putExtra(NoteDetailsActivity.EXTRA_BODY,mNoteList.get(position).getBody());
                intent.putExtra(NoteDetailsActivity.EXTRA_KEY,mNoteList.get(position).getKey());
                intent.putExtra(NoteDetailsActivity.EXTRA_ISFAVORITE,mNoteList.get(position).isFavorite());
                startActivity(intent);
            }
        });
        return view;
    }

}
