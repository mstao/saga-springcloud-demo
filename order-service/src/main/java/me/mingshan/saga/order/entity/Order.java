package me.mingshan.saga.order.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.mingshan.saga.api.order.enums.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Order implements Serializable {
    private static final long serialVersionUID = -2066544283413715828L;

    private long id;
    private long number;
    private long userId;
    private long productId;
    private BigDecimal price;
    private OrderStatus status;
}
