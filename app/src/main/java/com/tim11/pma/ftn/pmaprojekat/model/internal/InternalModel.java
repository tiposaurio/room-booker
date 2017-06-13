package com.tim11.pma.ftn.pmaprojekat.model.internal;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by ALOHA-PC on 13-May-17.
 */

public class InternalModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private int actualId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActualId() {
        return actualId;
    }

    public void setActualId(int actualId) {
        this.actualId = actualId;
    }


}
