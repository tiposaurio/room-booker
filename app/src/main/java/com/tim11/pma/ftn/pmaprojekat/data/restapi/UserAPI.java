package com.tim11.pma.ftn.pmaprojekat.data.restapi;

import com.tim11.pma.ftn.pmaprojekat.converter.MyGsonHttpMessageConverter;
import com.tim11.pma.ftn.pmaprojekat.model.User;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;

import java.util.List;

@Rest(rootUrl = APIConstants.ROOT_URL, converters = {MyGsonHttpMessageConverter.class,
        FormHttpMessageConverter.class})
public interface UserAPI {

    @Get(value = APIConstants.USER_PATH)
    List<User> getUsers();

    @Post(value = APIConstants.USER_PATH)
    User createUser(@Body User user);

    @Get(value = APIConstants.USER_PATH+"/{id}")
    User getUser(@Path int id);

    @Get(value = APIConstants.USER_PATH+"/fbProfileId/{fbProfileId}")
    User getUserByFbProfileId(@Path String fbProfileId);
}
