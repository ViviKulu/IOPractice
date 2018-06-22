package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "petition_table")
public class Petition {

    @PrimaryKey()
    @NonNull
    private String petition;

    public Petition(String petition) {
        this.petition = this.petition;
    }

    public String getPetition() {
        return petition;
    }

    public void setPetition(String petition) {
        this.petition = petition;
    }
}
