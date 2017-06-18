package com.erenutku.bottomnavigationexample301;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erenutku.bottomnavigationexample301.models.Ogrenci;
import com.erenutku.bottomnavigationexample301.models.OgrencilerResponse;

/**
 * Created by yutku on 17/06/17.
 */

public class CustomAdapter extends BaseAdapter {
    private OgrencilerResponse mOgrencilerResponse;
    private Context mContext;

    public CustomAdapter(Context context, OgrencilerResponse ogrencilerResponse){
        mOgrencilerResponse = ogrencilerResponse;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mOgrencilerResponse.getOgrenciler().size();
    }

    @Override
    public Ogrenci getItem(int i) {
        return mOgrencilerResponse.getOgrenciler().get(i);
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
        textView.setText(mOgrencilerResponse.getOgrenciler().get(i).getOgrenci()+":"+mOgrencilerResponse.getOgrenciler().get(i).getYas());
        return rootView;
    }
}
