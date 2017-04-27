package com.example.asus.lab2;

/**
 * Created by ASUS on 27/04/2017.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyLineAdapter extends ArrayAdapter<String> {
        Activity context;
        String[] items;

        MyLineAdapter(Activity context, String[] items){
        super(context,R.layout.customlayout, items);
        this.context = context;
        this.items = items;
        }
        //method 3
        static class ViewHolder{
                TextView label;
                ImageView image;
        }

//method 2
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder holder;
        if (convertView == null){
                convertView = inflater.inflate(R.layout.customlayout, null);

                holder = new ViewHolder();
                holder.label = (TextView) convertView.findViewById(R.id.grade);
                holder.image = (ImageView) convertView.findViewById(R.id.image);

                convertView.setTag(holder);
        }else{
                holder = (ViewHolder) convertView.getTag();
        }

        holder.label.setText(items[position]);
        float grade = Float.valueOf(items[position]);
        holder.image.setImageResource((grade >= 10)?R.drawable.ic_mood : R.drawable.ic_mood_bad);

        return convertView;
        }

        //method 2
        /**public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                if (convertView == null){
                        convertView = inflater.inflate(R.layout.customlayout, null);
                }

                TextView label = (TextView) convertView.findViewById(R.id.grade);
                ImageView image = (ImageView) convertView.findViewById(R.id.image);
                label.setText(items[position]);
                float grade = Float.valueOf(items[position]);
                image.setImageResource((grade >= 10)?R.drawable.ic_mood : R.drawable.ic_mood_bad);
                return convertView;
        } **/

//method 1
        /** View getView(int position, View convertView, ViewGroup parent) {
         LayoutInflater inflater = context.getLayoutInflater();
         View line = inflater.inflate(R.layout.customlayout, null);
         TextView label = (TextView) line.findViewById(R.id.grade);
         ImageView image = (ImageView) line.findViewById(R.id.image);
         label.setText(items[position]);
         float grade = Float.valueOf(items[position]);
         image.setImageResource((grade >= 10)?R.drawable.ic_mood : R.drawable.ic_mood_bad);
         return line;
         }**/
}
