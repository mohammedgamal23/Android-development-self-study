package com.example.prof.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class CustomListView extends AppCompatActivity {
    ListView customListView;
    int []images ={R.drawable.cat03,R.drawable.dog,R.drawable.lion,R.drawable.bitches,R.drawable.rabbit};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistview);
        customListView = findViewById(R.id.customlist);
        customListView.setAdapter(new myAdapter(this,android.R.layout.simple_list_item_1,list.animals));

    }

    public class myAdapter extends ArrayAdapter<String> {
        public myAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.list_item,parent,false);
            TextView tv = v.findViewById(R.id.txt);
            tv.setText(list.animals[position]);
            ImageView imgview= v.findViewById(R.id.imgview);
            imgview.setImageResource(images[position]);
            return v;
        }
    }

}
