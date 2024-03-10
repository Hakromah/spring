package com.hskspring.eazyschool.model;

import lombok.Data;

/*
@Data annotation is provided by Lombok library which generates getter, setter,
equals(), hashCode(), toString() methods & Constructor at compile time.
This makes our code short and clean.
* */
@Data
public class Holiday extends BaseEntity{
    private String day;
    private String reason;
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
