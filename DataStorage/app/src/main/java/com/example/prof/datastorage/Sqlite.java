package com.example.prof.datastorage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Sqlite extends AppCompatActivity {
    EditText eTxtStudents;
    Button btnAddStudents;
    ListView lvStudents;
    SQLiteDatabase sqLiteDatabase;
    DB mydb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);
        eTxtStudents = findViewById(R.id.etxtStudent);
        btnAddStudents = findViewById(R.id.btnAdd);
        lvStudents = findViewById(R.id.lvstudents);
        sqLiteDatabase = openOrCreateDatabase("test",0,null);
        mydb = new DB(sqLiteDatabase);
        mydb.createTable();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mydb.getAll());
        lvStudents.setAdapter(adapter);
        btnAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eTxtStudents.getText().toString();
                mydb.insertStudent(name);
                ArrayAdapter<String> adapter1 = (ArrayAdapter<String>) lvStudents.getAdapter();
                adapter1.add(name);
                adapter1.notifyDataSetChanged();
            }
        });

    }
}
