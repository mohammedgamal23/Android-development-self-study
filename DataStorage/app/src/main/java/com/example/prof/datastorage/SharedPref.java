package com.example.prof.datastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SharedPref extends AppCompatActivity {
    EditText name,pass;
    CheckBox chk;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpref);
        name = findViewById(R.id.edituser);
        pass = findViewById(R.id.editpass);
        chk = findViewById(R.id.chkremeber);
        btn = findViewById(R.id.btnsignin);
        SharedPreferences pref = getSharedPreferences("test",0);
        if(pref.getBoolean("x",false))
        {
            String name1 =pref.getString("y","");
            name.setText(name1);
            String pass1 =pref.getString("z","");
            pass.setText(pass1);
            chk.setChecked(true);

        }
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chk.isChecked())
                {
                    SharedPreferences pref = getSharedPreferences("test",0);
                    SharedPreferences.Editor handler = pref.edit();
                    handler.putString("y",name.getText().toString());
                    handler.putString("z",pass.getText().toString());
                    handler.putBoolean("x",true);
                    handler.commit();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
