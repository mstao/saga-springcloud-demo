package me.mingshan.saga.api.product.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author mingshan
 */
@Getter
@Setter
@ToString
public class ProductVO implements Serializable {
    private static final long serialVersionUID = 3808070984328103577L;

    private String id;
    private String name;
    private int stock;
    private BigDecimal price;

}
