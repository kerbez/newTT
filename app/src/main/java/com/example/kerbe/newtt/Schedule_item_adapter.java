package com.example.kerbe.newtt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kerbe on 07.04.2018.
 */

public class Schedule_item_adapter extends ArrayAdapter<Klass> implements View.OnClickListener {

    private ArrayList<Klass> data;
    Context mContext;

    private static class ViewHolder{
        TextView subject, teacher, place,  start, finish, kind,  group;
        ImageView right_b;
    }

    public Schedule_item_adapter(ArrayList<Klass> data, Context context){
        super(context, R.layout.schedule_item, data);
        this.data = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {
        int pos = (Integer) view.getTag();
        Object ob = getItem(pos);
        Klass klass  = (Klass)ob;
        switch (view.getId()){
            case R.id.right_b:
                Toast.makeText(mContext, "right button", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public View getView(int pos, View convertView, ViewGroup parent){
        Klass klass = getItem(pos);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.schedule_item, parent, false);
            viewHolder.kind = (TextView) convertView.findViewById(R.id.kind_item);
            viewHolder.subject = (TextView) convertView.findViewById(R.id.sub_item);
            viewHolder.teacher = (TextView) convertView.findViewById(R.id.tea_item);
            viewHolder.place = (TextView) convertView.findViewById(R.id.place_item);
            viewHolder.start = (TextView) convertView.findViewById(R.id.start_item);
            viewHolder.finish = (TextView) convertView.findViewById(R.id.finish_item);
            viewHolder.group = (TextView) convertView.findViewById(R.id.group_item);
            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        return convertView;
    }
}
