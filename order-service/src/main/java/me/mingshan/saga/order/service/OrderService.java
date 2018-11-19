package me.mingshan.saga.order.service;

import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.common.base.exception.ServiceException;

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
    List<OrderDTO> getByUserId(Long userId) throws ServiceException;

    /**
     * Saves order
     *
     * @param orderDTO
     * @return
     */
    Long save(OrderDTO orderDTO) throws ServiceException;

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
