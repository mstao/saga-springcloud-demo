package me.mingshan.saga.account.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 2935109244805914966L;
    private long id;
    private String name;
    private int age;

    private Date gmtCreate;
    private Date gmtModified;
}
