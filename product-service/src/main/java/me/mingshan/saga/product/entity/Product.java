package me.mingshan.saga.product.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = 2412416935107923526L;

    private String name;
    private int stock;
    private BigDecimal price;
}
