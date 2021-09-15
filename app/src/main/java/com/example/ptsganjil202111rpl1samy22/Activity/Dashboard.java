package com.example.ptsganjil202111rpl1samy22.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ptsganjil202111rpl1samy22.R;

public class Dashboard extends AppCompatActivity {
    Button buttonlist, buttonfav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        buttonlist = findViewById(R.id.buttonList);
        buttonfav = findViewById(R.id.buttonFav);

        buttonlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SportActivity.class));
            }
        });

        buttonfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FavoriteActivity.class));
            }
        });

    }
}