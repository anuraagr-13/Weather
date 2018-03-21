package com.example.hp.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity2 extends AppCompatActivity {
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt1 =(Button)findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
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

            TextView minTextView = convertView.findViewById(R.id.textView5);
            TextView maxTextView = convertView.findViewById(R.id.textView6);

            minTextView.setText(weather.getMinTemp());
            maxTextView.setText(weather.getMaxTemp());

            return convertView;
        }
}}

