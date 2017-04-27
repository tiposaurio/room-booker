package com.tim11.pma.ftn.pmaprojekat.model;

/**
 * Created by ALOHA-PC on 27-Apr-17.
 */

public class SpringTestModel {

    String type;
    Value value;

    public SpringTestModel(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public class Value{

        String id;
        String quote;

        public Value(String id, String quote) {
            this.id = id;
            this.quote = quote;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }
    }

}
