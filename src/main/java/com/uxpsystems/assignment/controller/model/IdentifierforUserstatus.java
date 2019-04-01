
package com.uxpsystems.assignment.controller.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum IdentifierforUserstatus {

    @JsonProperty("ACTIVATED")
    ACTIVATED("ACTIVATED"),
    @JsonProperty("DEACTIVATED")
    DEACTIVATED("DEACTIVATED");
    private final String value;
    private final static Map<String, IdentifierforUserstatus> VALUE_CACHE = new HashMap<String, IdentifierforUserstatus>();

    static {
        for (IdentifierforUserstatus c: values()) {
            VALUE_CACHE.put(c.value, c);
        }
    }

    private IdentifierforUserstatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static IdentifierforUserstatus fromValue(String value) {
        return VALUE_CACHE.get(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
