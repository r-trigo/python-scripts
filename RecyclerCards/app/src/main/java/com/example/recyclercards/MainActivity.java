package com.example.recyclercards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button viewHeroes;
    Button viewMap;
    Button viewMap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewHeroes = (Button) findViewById(R.id.button_viewHeroes);
        viewHeroes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,ViewHeroesActivity.class);
                startActivity(intent);
            }
        });

        viewMap = (Button) findViewById(R.id.button_viewMap);
        viewMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,SeeMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
