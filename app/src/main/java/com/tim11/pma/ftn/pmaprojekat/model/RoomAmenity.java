package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class RoomAmenity {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int roomId;

    @DatabaseField
    private int amenityId;

    public RoomAmenity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }
}
