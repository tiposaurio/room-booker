package com.tim11.pma.ftn.pmaprojekat.data.restapi;

/**
 * Created by ALOHA-PC on 27-Apr-17.
 */

public interface APIConstants {

    /* for testing - this link returns random object (SpringTestModel.java)*/
    String TEST_URL = "https://gturnquist-quoters.cfapps.io/api/random";

    /* base url, something like 'localhost:8080' */
    //TODO: For debugging purpose put IP address of your database service's machine
    //String ROOL_URL = "https://enigmatic-shore-56356.herokuapp.com/api";
    String ROOL_URL = "http://192.168.1.108:8080/api";

    /*ADD ENTITY PATHS HERE */

    /* Hotel */
    String HOTEL_PATH = "/hotel";

    String RESERVATION_PATH = "/reservation";


    // ...



}
