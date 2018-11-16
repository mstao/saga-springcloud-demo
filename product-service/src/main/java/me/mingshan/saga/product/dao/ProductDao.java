package me.mingshan.saga.product.dao;

import me.mingshan.saga.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    Long insert(Product product);

    void delete(Long id);

    Product findById(Long id);
}
