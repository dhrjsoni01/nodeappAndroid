package com.example.ankita.nodeappandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankita.nodeappandroid.R;

/**
 * Created by ss on 3/23/2018.
 */

public class gridAdapter extends BaseAdapter {

    private Context context;
    private String[] name;
    private int[] image;

    public gridAdapter(Context context,String[] name,int[] image){
        this.context=context;
        this.name=name;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.length;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            grid=new View(context);
            grid=inflater.inflate(R.layout.category_grid_element,null);
            TextView textView=(TextView)grid.findViewById(R.id.text);
            ImageView imageView=(ImageView)grid.findViewById(R.id.image);
            textView.setText(name[position]);
            imageView.setImageResource(image[position]);
        }
        else
        {
            grid=(View) convertView;
        }
        return grid;
    }
}
