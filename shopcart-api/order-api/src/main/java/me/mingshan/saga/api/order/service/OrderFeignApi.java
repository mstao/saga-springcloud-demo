package me.mingshan.saga.api.order.service;

import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.api.order.service.hystrix.OrderFeignHystrix;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import me.mingshan.saga.common.base.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mingshan
 */
@FeignClient(value = "order-service", fallback = OrderFeignHystrix.class)
public interface OrderFeignApi {

    /**
     * Gets order by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/api/order/{id}")
    ResponseEntity<ResultModel<OrderVO>> getById(@PathVariable("id") Long id);

    /**
     * Gets orders by user id.
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/order/getByUserId/{userId}")
    ResponseEntity<ResultModel<OrderVO>> getByUserId(@PathVariable("userId") long userId);

    /**
     * Saves order
     *
     * @param orderDTO
     * @return
     */
    @PostMapping(value = "/api/order")
    ResponseEntity<ResultModel<Long>> save(@RequestBody OrderDTO orderDTO) throws ServiceException;

    /**
     *
     * @param orderDTO
     */
    @PutMapping(value = "/api/order")
    void update(@RequestBody OrderDTO orderDTO);

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/api/order/{id}")
    void delete(@PathVariable("id") String id);
}
