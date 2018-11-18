package me.mingshan.saga.order.dao;

import me.mingshan.saga.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    Long insert(Order order);

    void delete(Long id);

    Order findById(Long id);

    List<Order> findByUserId(Long userId);
}
