package me.mingshan.saga.api.account.model.dto;

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
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -2647402767487870069L;

    private long id;
    private String name;
    private int age;

}
