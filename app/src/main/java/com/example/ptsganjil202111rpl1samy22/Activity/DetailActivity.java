package com.example.ptsganjil202111rpl1samy22.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ptsganjil202111rpl1samy22.Class.RealmHelper;
import com.example.ptsganjil202111rpl1samy22.Model.SportModel;
import com.example.ptsganjil202111rpl1samy22.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity {
    FloatingActionButton buttonfav;
    Realm realm;
    RealmHelper realmHelper;

    ImageView detailSportPic;
    TextView detailSportName, detailSportFormat, detailSportDescripption;
    String sportpic, sportname, sportformat, sportdescription;
    int id;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        buttonfav = findViewById(R.id.floating_action_button);

        detailSportName = findViewById(R.id.detail_sportName);
        detailSportFormat = findViewById(R.id.detail_sportFormat);
        detailSportDescripption = findViewById(R.id.detail_sportDescription);
        detailSportPic = findViewById(R.id.detail_sporPic);

        bundle = getIntent().getExtras();

        if (bundle != null) {

            id = bundle.getInt("id");
            sportname = bundle.getString("sportName");
            sportformat = bundle.getString("sportFormat");
            sportdescription = bundle.getString("sportDescription");
            sportpic = bundle.getString("sportPic");
            getSupportActionBar().setTitle(sportname);

        }

        detailSportName.setText(sportname);
        detailSportFormat.setText(sportformat);
        detailSportDescripption.setText(sportdescription);
        Glide.with(getApplicationContext())
                .load(sportpic)
                .into(detailSportPic);


        //Realm
        Realm.init(DetailActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().allowWritesOnUiThread(true).build();
        realm = Realm.getInstance(configuration);

        buttonfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportModel model = new SportModel(id, sportname, sportformat, sportdescription, sportpic);
                realmHelper = new RealmHelper(realm);
                realmHelper.save(model);


                Toast.makeText(DetailActivity.this, "Sukses Ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });


    }
}