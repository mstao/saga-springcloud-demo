package me.mingshan.saga.common.base.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResultModel implements Serializable {
    private static final long serialVersionUID = -1349652535902847834L;
    private long code;
    private String message;
    private Object content;
}
