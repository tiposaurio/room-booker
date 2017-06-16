package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Address;
import com.tim11.pma.ftn.pmaprojekat.model.Bed;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class AddressDAO extends RuntimeExceptionDao<Address,Integer> {

    public AddressDAO(Dao<Address, Integer> dao) {
        super(dao);
    }
}
