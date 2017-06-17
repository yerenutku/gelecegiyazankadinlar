package com.erenutku.bottomnavigationviewexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomNavFirstMenuFragment extends Fragment {
    String text;

    public BottomNavFirstMenuFragment() {
        // Required empty public constructor
    }
    public static BottomNavFirstMenuFragment newInstance(String s){
        BottomNavFirstMenuFragment bottomNavFirstMenuFragment = new BottomNavFirstMenuFragment();
        bottomNavFirstMenuFragment.text = s;
        return bottomNavFirstMenuFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_nav_first_menu, container, false);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        tv1.setText(text);
        return view;
    }

}
