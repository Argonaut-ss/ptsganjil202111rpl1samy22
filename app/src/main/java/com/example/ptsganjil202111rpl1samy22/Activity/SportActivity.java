package com.example.ptsganjil202111rpl1samy22.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.ptsganjil202111rpl1samy22.Adapter.SportAdapter;
import com.example.ptsganjil202111rpl1samy22.Model.SportModel;
import com.example.ptsganjil202111rpl1samy22.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SportActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SportAdapter adapter;
    ArrayList<SportModel> sportlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); recyclerView = findViewById(R.id.rvSport);

        getData();

        sportlist = new ArrayList<>();
        adapter = new SportAdapter(sportlist, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void getData(){
        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/all_sports.php")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = response.getJSONArray("sports");
                            for (int i = 0; i < data.length() ; i++) {
                                JSONObject resultObj = data.getJSONObject(i);

                                String sportName = resultObj.getString("strSport");
                                String sportFormat = resultObj.getString("strFormat");
                                String sportDescription = resultObj.getString("strSportDescription");
                                String sportPic = resultObj.getString("strSportThumb");


                                sportlist.add(new SportModel(i, sportName, sportFormat, sportDescription, sportPic));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }




}