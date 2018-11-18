package me.mingshan.saga.api.order.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.mingshan.saga.api.order.enums.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author mingshan
 */
@Getter
@Setter
@ToString
public class OrderVO implements Serializable {
    private static final long serialVersionUID = 8560422613763850415L;

    private long id;
    private long userId;
    private long productId;
    private String number;
    private BigDecimal price;
    private OrderStatus status;

}
