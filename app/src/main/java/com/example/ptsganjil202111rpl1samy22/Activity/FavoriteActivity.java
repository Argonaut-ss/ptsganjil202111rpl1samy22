package com.example.ptsganjil202111rpl1samy22.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ptsganjil202111rpl1samy22.Adapter.FavoriteAdapter;
import com.example.ptsganjil202111rpl1samy22.Class.RealmHelper;
import com.example.ptsganjil202111rpl1samy22.Model.SportModel;
import com.example.ptsganjil202111rpl1samy22.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FavoriteAdapter adapter2;
    List<SportModel> sportlist;
    Realm realm;
    RealmHelper realmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recyclerView = findViewById(R.id.rvSport);

        recyclerView.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));

        sportlist = new ArrayList<>();

        RealmConfiguration configuration = new RealmConfiguration.Builder().allowWritesOnUiThread(true).build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        sportlist = new ArrayList<>();

        sportlist = realmHelper.gelAllSport();

        adapter2 = new FavoriteAdapter(sportlist, this);
        recyclerView.setAdapter(adapter2);


    }
}