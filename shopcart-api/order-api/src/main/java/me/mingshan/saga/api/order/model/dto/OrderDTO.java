package me.mingshan.saga.api.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.mingshan.saga.api.order.enums.OrderStatus;

import java.io.Serializable;

/**
 * @author mingshan
 */
@Getter
@Setter
@ToString
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = -4729240359519844165L;

    private long userId;
    private long productId;
    private String number;
    private int price;
    private OrderStatus status;

}
