package com.example.prof.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_shared:
                Toast.makeText(getApplicationContext(),"TO SharedPref",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SharedPref.class);
                startActivity(intent);
                break;
            case R.id.action_file:
                Toast.makeText(getApplicationContext(),"TO File_IO",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,File_IO.class));
                break;
            case R.id.action_sql:
                Toast.makeText(getApplicationContext(),"TO Sqlite",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Sqlite.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
