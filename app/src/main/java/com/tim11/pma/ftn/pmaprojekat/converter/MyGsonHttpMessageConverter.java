package com.tim11.pma.ftn.pmaprojekat.converter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Jan Sulja on 5/12/2017.
 */

public class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {
    public MyGsonHttpMessageConverter(){

        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        setGson(builder.create());

    };
}
