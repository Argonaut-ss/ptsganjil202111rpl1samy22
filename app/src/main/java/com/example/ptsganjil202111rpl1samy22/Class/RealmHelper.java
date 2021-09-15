package com.example.ptsganjil202111rpl1samy22.Class;

import android.util.Log;
import android.widget.Toast;

import com.example.ptsganjil202111rpl1samy22.Model.SportModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final SportModel sportModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(SportModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    sportModel.setId(nextId);
                    SportModel model = realm.copyToRealm(sportModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }
    //menampilkan data

    public List<SportModel> gelAllSport() {
        RealmResults<SportModel> results = realm.where(SportModel.class).findAll();
        return results;
    }


    // menghapus
    public void delete(Integer id){

        realm.executeTransaction(new Realm.Transaction() {
            final SportModel model = realm.where(SportModel.class).equalTo("id", id).findFirst();
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm();
            }
        });
    }


}
