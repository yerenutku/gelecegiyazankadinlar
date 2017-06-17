package com.erenutku.bottomnavigationexample301;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yutku on 17/06/17.
 */

public class CustomAdapter extends BaseAdapter {
    private ArrayList<CustomModel> mArrayList;
    private Context mContext;

    public CustomAdapter(Context context, ArrayList<CustomModel> arrayList){
        mArrayList = arrayList;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public CustomModel getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.custom_listview_layout,null);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ivPp);
        TextView textView = (TextView) rootView.findViewById(R.id.tvText);
        textView.setText(mArrayList.get(i).getText());
        imageView.setBackgroundResource(mArrayList.get(i).getResourceId());
        return rootView;
    }
}
