package me.mingshan.saga.product.dao;

import me.mingshan.saga.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    Long insert(Product product);

    Product findById(Long id);

    void decreaseStock(Long id, int number);

    void increaseStock(Long id, int number);

}
