package com.okandonmez.leveldesign;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomLevelsAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final int [] images;
    View view;
    LayoutInflater layoutInflater;

    public CustomLevelsAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.singleitem, null);

            ImageView img = view.findViewById(R.id.si_imgLogo);
            TextView txt = view.findViewById(R.id.si_txtTitle);

            img.setImageResource(images[i]);
            txt.setText(values[i]);
        }

        return view;
    }
}