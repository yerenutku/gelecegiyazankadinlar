package com.erenutku.bottomnavigationexample301;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.erenutku.bottomnavigationexample301.models.CustomModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private ListView mListView;
    private ArrayList<CustomModel> mArrayList = new ArrayList<>();

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        mListView = (ListView) view.findViewById(R.id.lvList);
        mArrayList.add(new CustomModel("Burası 1",R.drawable.ic_face_black_24dp));
        mArrayList.add(new CustomModel("Burası 2",R.drawable.ic_copyright_black_24dp));
        mArrayList.add(new CustomModel("Burası 3",R.drawable.ic_favorite_black_24dp));
        mArrayList.add(new CustomModel("Burası 4",R.drawable.ic_face_black_24dp));
        mArrayList.add(new CustomModel("Burası 5",R.drawable.ic_copyright_black_24dp));
        CustomAdapter customAdapter = new CustomAdapter(getContext(),mArrayList);
        mListView.setAdapter(customAdapter);
        return view;
    }

}
