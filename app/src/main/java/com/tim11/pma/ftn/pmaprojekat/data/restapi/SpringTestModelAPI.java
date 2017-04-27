package com.tim11.pma.ftn.pmaprojekat.data.restapi;

import com.tim11.pma.ftn.pmaprojekat.model.SpringTestModel;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;


@Rest(rootUrl = APIConstants.TEST_URL, converters = {GsonHttpMessageConverter.class,
        FormHttpMessageConverter.class})
public interface SpringTestModelAPI {

    /* for testing */
    @Get(value = "")
    SpringTestModel getSpringTestModel();

}

