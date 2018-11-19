package me.mingshan.saga.api.account.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author mingshan
 */
@Getter
@Setter
@ToString
public class UserVO implements Serializable {
    private static final long serialVersionUID = -6122663463821155939L;

    private long id;
    private String name;
    private int age;

}
