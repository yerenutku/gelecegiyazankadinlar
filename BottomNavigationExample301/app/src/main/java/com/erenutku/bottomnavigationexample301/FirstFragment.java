package com.erenutku.bottomnavigationexample301;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private String text;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String text){
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.text = text;
        return firstFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        textView.setText(text);
        return view;
    }

}
