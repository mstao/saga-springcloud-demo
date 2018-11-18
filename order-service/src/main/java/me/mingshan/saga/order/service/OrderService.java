package me.mingshan.saga.order.service;

import me.mingshan.saga.api.order.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    /**
     * Gets order by id.
     *
     * @param id
     * @return
     */
    OrderDTO getById(Long id);

    /**
     * Gets orders by user id.
     *
     * @param userId
     * @return
     */
    List<OrderDTO> getByUserId(Long userId);

    /**
     * Saves order
     *
     * @param orderDTO
     * @return
     */
    Long save(OrderDTO orderDTO);

    /**
     *
     * @param orderDTO
     */
    void update(OrderDTO orderDTO);

    /**
     *
     * @param id
     */
    void delete(Long id);
}
