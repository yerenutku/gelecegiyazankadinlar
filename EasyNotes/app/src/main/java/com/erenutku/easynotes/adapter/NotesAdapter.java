package com.erenutku.easynotes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erenutku.easynotes.R;
import com.erenutku.easynotes.model.NoteModel;

import java.util.ArrayList;

/**
 * Created by yutku on 08/07/17.
 */

public class NotesAdapter extends BaseAdapter {
    private ArrayList<NoteModel> mNoteList;
    private Context mContext;

    public NotesAdapter(Context context, ArrayList<NoteModel> noteList) {
        mNoteList = noteList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mNoteList.size();
    }

    @Override
    public Object getItem(int i) {
        return mNoteList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.item_notes_layout,null);

        TextView tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) rootView.findViewById(R.id.tvBody);

        tvTitle.setText(mNoteList.get(i).getTitle());
        tvBody.setText(mNoteList.get(i).getBody());

        return rootView;
    }
}
