package com.example.prof.datastorage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_IO extends AppCompatActivity {
    EditText etxtWriteToFile;
    TextView txtviewReadToFile;
    Button btnWrite;
    final String FILE_NAME = "tempFile.txt";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_io);
        etxtWriteToFile = findViewById(R.id.edit_data);
        txtviewReadToFile = findViewById(R.id.readfromfile);
        btnWrite = findViewById(R.id.btnwrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos=openFileOutput(FILE_NAME,MODE_APPEND);
                    fos.write(etxtWriteToFile.getText().toString().getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),"Written",Toast.LENGTH_LONG).show();
                    readFromFile();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void readFromFile()
    {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte [] buffer = new byte[fis.available()];
            fis.read(buffer);
            txtviewReadToFile.setText(new String(buffer));
            File file = getFilesDir();
            Log.d("Path",file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        readFromFile();
    }
}
