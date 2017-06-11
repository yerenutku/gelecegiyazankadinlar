package com.erenutku.customlistviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yutku on 11/06/17.
 */

public class CustomArrayAdapter extends BaseAdapter{
    private List<Model_Human> mHumanList;
    private Activity mActivity;

    public CustomArrayAdapter(Activity activity, List<Model_Human> list){
        mActivity = activity;
        mHumanList = list;
    }


    @Override
    public int getCount() {
        return mHumanList.size();
    }

    @Override
    public Model_Human getItem(int i) {
        return mHumanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View parentView = inflater.inflate(R.layout.custom_item_layout,null);
        ImageView imageView = (ImageView) parentView.findViewById(R.id.ivPp);
        TextView textView = (TextView) parentView.findViewById(R.id.tvDesc);

        if (mHumanList.get(i).getAction()){
            imageView.setBackgroundResource(R.drawable.ic_directions_run_black_24dp);
        }
        else {
            imageView.setBackgroundResource(R.drawable.ic_pool_black_24dp);
        }

        textView.setText(mHumanList.get(i).getName());

        return parentView;
    }
}
