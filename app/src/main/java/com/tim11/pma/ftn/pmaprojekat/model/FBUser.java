package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;

public class FBUser implements Serializable {

    private int id;

    private String fbProfileId;

    private String firstname;

    private String middlename;

    private String lastname;

    private String profileUri;

    private String profilePictureUri;

    private User user;

    public FBUser() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFbProfileId() {
        return fbProfileId;
    }

    public void setFbProfileId(String fbProfileId) {
        this.fbProfileId = fbProfileId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileUri() {
        return profileUri;
    }

    public void setProfileUri(String profileUri) {
        this.profileUri = profileUri;
    }

    public String getProfilePictureUri() {
        return profilePictureUri;
    }

    public void setProfilePictureUri(String profilePictureUri) {
        this.profilePictureUri = profilePictureUri;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
