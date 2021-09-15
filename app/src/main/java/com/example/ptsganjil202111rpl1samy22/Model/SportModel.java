package com.example.ptsganjil202111rpl1samy22.Model;

import io.realm.RealmObject;

public class SportModel extends RealmObject {
    private int id;
    private String sportName;
    private String sportFormat;
    private String sportDescription;
    private String sportPic;

    public SportModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportFormat() {
        return sportFormat;
    }

    public void setSportFormat(String sportFormat) {
        this.sportFormat = sportFormat;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }

    public String getSportPic() {
        return sportPic;
    }

    public void setSportPic(String sportPic) {
        this.sportPic = sportPic;
    }



    public SportModel(int id, String sportName, String sportFormat, String sportDescription, String sportPic) {
        this.id = id;
        this.sportName = sportName;
        this.sportFormat = sportFormat;
        this.sportDescription = sportDescription;
        this.sportPic = sportPic;
    }





}
