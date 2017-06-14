package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Bed;
import com.tim11.pma.ftn.pmaprojekat.model.Price;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class BedDAO extends RuntimeExceptionDao<Bed,Integer> {

    public BedDAO(Dao<Bed, Integer> dao) {
        super(dao);
    }
}
