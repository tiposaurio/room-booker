package com.tim11.pma.ftn.pmaprojekat.service;

import java.util.List;

/**
 * Created by ALOHA-PC on 27-Apr-17.
 */

public interface GenericService<T> {

    List<T> get();

    T create(T entity);

    T getById(int id);
}
