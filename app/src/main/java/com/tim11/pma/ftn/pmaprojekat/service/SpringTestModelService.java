package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.model.SpringTestModel;
import com.tim11.pma.ftn.pmaprojekat.data.restapi.SpringTestModelAPI;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALOHA-PC on 27-Apr-17.
 */
@EBean
public class SpringTestModelService implements GenericService<SpringTestModel>{

    @RestService
    SpringTestModelAPI springTestModelApi;

    @Override
    public List<SpringTestModel> get() {
        ArrayList<SpringTestModel> l = new ArrayList<>();
        l.add(springTestModelApi.getSpringTestModel());
        return l;
    }

    @Override
    public SpringTestModel create(SpringTestModel entity) {
        return null;
    }

    @Override
    public SpringTestModel getById(int id) {
        return null;
    }

}
