package com.example.prof.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button linear,relative,table,tap,list,grid,custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        relative = findViewById(R.id.relative);
        table = findViewById(R.id.table);
        tap = findViewById(R.id.tap);
        list = findViewById(R.id.list);
        grid = findViewById(R.id.grid);
        custom = findViewById(R.id.custom);
    }

    public void linear(View view) {
        Intent intent = new Intent(this,Linear.class);
        startActivity(intent);
    }

    public void relative(View view) {
        Intent intent = new Intent(this,Relative.class);
        startActivity(intent);
    }

    public void table(View view) {
        Intent intent= new Intent(this,table.class);
        startActivity(intent);
    }


    public void tap(View view) {
        Intent intent = new Intent(this,tab.class);
        startActivity(intent);
    }

    public void list(View view) {
        Intent intent = new Intent(this,list.class);
        startActivity(intent);
    }

    public void grid(View view) {
        Intent intent = new Intent(this,grid.class);
        startActivity(intent);
    }

    public void custom(View view) {
        Intent intent = new Intent(this,CustomListView.class);
        startActivity(intent);
    }

}
