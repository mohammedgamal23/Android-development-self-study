package com.example.prof.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.Toast;

public class tab extends AppCompatActivity {
    TabHost tab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
        tab = findViewById(R.id.tabHost);
        tab.setup();
        TabHost.TabSpec spec = tab.newTabSpec("tag1");
        spec.setIndicator("Missed");
        spec.setContent(R.id.tab1);
        tab.addTab(spec);

        spec = tab.newTabSpec("tag2");
        spec.setIndicator("Received");
        spec.setContent(R.id.tab2);
        tab.addTab(spec);

        spec = tab.newTabSpec("tag3");
        spec.setIndicator("outgoing");
        spec.setContent(R.id.tab3);
        tab.addTab(spec);

        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s)
                {
                    case "tag1":
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                        break;

                    case "tag2":
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                        break;

                    case "tag3":
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                        break;

                }

            }
        });
    }
}
