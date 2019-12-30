package com.example.prof.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class grid extends AppCompatActivity {
    GridView g;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        g = findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        g.setAdapter(imageAdapter);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(grid.this,"Hello" + i,Toast.LENGTH_LONG).show();
            }
        });
    }
    public class ImageAdapter extends BaseAdapter
    {
        Context mcontext;
        private int[] iMages= {
                R.drawable.cat03,R.drawable.dog,
                R.drawable.lion,R.drawable.bitches,R.drawable.rabbit,
                R.drawable.cat03,R.drawable.dog,
                R.drawable.lion,R.drawable.bitches,R.drawable.rabbit,
                R.drawable.cat03,R.drawable.dog,
                R.drawable.lion,R.drawable.bitches,R.drawable.rabbit,
                R.drawable.cat03,R.drawable.dog,
                R.drawable.lion,R.drawable.bitches,R.drawable.rabbit,
        };

        public ImageAdapter(Context c)
        {
            mcontext = c;
        }
        @Override
        public int getCount() {
            return iMages.length;
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
            ImageView imageView;
            if (view == null)
            {
                imageView = new ImageView(mcontext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(125,125));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);
            }else
            {
                imageView = (ImageView)view;
            }
            imageView.setImageResource(iMages[i]);
            return imageView;
        }
    }
}
