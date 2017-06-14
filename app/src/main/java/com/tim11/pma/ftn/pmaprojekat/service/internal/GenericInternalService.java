package com.tim11.pma.ftn.pmaprojekat.service.internal;

import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public interface GenericInternalService<T> {

    List<T> getAll();

    T create(T entity);

    void createAll(List<T> list);

    T getById(int id);

}
