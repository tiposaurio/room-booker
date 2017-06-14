package com.tim11.pma.ftn.pmaprojekat.converter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                String date = sdf.format(src);
                JsonElement jsonElement = new JsonPrimitive(date);
                return jsonElement;
            }
        });


        setGson(builder.create());

    };
}
