package com.redhat.service.smartevents.infra.models.processors;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProcessorType implements BaseEnumeration {
    SOURCE("source"),
    SINK("sink");

    final String value;

    ProcessorType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    // We can not annotate the property `value` directly with `@JsonValue`. See https://issues.redhat.com/browse/MGDOBR-595
    public String getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    // Required for JAX-RS deserialisation. See @javax.ws.rs.QueryParam.
    public static ProcessorType fromString(String type) {
        return BaseEnumeration.lookup(values(), type);
    }

}
