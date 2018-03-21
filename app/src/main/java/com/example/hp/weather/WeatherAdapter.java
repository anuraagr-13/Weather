package com.example.hp.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.hp.weather.R.id.tvLowTemperature;

/**
 * Created by HP on 18-03-2018.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {

    public WeatherAdapter(@NonNull Context context, ArrayList<Weather> weatherArrayList) {
        super(context,0,weatherArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView dateTextView=convertView.findViewById(R.id.Date);
        TextView minTextView = convertView.findViewById(tvLowTemperature);
        TextView maxTextView = convertView.findViewById(R.id.tvHighTemperature);

        dateTextView.setText(weather.getDate());
        minTextView.setText(weather.getMinTemp());
        maxTextView.setText(weather.getMaxTemp());

        return convertView;
    }
}
