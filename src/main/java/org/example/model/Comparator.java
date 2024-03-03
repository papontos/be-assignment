package org.example.model;

import java.util.Arrays;

public enum Comparator {
    EQ("eq"), GTE("gte"), GT("gt"), LT("lt"), LTE("lte");

    private final String value;
    Comparator(String value) {
        this.value = value;
    }

    public static Comparator fromString(String value) {
        for(var comparator: Comparator.values()){
            if (comparator.value.equalsIgnoreCase(value)) {
                return comparator;
            }
        }
        throw new RuntimeException("fail to parse comparator");
    }

}
