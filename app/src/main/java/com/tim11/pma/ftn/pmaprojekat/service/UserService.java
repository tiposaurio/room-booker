package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.data.restapi.UserAPI;
import com.tim11.pma.ftn.pmaprojekat.model.User;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

@EBean
public class UserService implements GenericService<User> {

    @RestService
    UserAPI userAPI;

    @Override
    public List<User> get() {
        return userAPI.getUsers();
    }

    @Override
    public User create(User user) {
        return userAPI.createUser(user);
    }

    @Override
    public User getById(int id) {
        return userAPI.getUser(id);
    }

    public User getUserByFbProfileId(String fbProfileId) {
        return userAPI.getUserByFbProfileId(fbProfileId);
    }
}
