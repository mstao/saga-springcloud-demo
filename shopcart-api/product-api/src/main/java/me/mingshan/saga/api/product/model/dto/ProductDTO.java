package me.mingshan.saga.api.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 3725687939544618493L;

    private long id;
    private String name;
    private int stock;
    private BigDecimal price;

}
