package me.mingshan.saga.common.base.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResultModel implements Serializable {
    private static final long serialVersionUID = -1349652535902847834L;
    private long code;
    private String message;
    private Object content;
}
