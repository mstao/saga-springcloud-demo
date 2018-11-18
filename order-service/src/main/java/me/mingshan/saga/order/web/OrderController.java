package me.mingshan.saga.order.web;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MapperFacade orikaMapperFacade;

    /**
     * Gets order by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/api/order/{id}")
    public ResponseEntity<ResultModel> getById(@PathVariable("id") Long id) {
        OrderDTO orderDTO = orderService.getById(id);
        OrderVO orderVo = orikaMapperFacade.map(orderDTO, OrderVO.class);
        orderVo.setStatus(orderDTO.getStatus());
        return null;
    }

    /**
     * Gets orders by user id.
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/order/getByUserId/{userId}")
    List<OrderVO> getByUserId(@PathVariable("userId") long userId) {
        return null;
    }

    /**
     * Saves order
     *
     * @param orderDTO
     * @return
     */
    @PostMapping(value = "/api/order")
    String save(OrderDTO orderDTO) {
        return null;
    }

    /**
     *
     * @param orderDTO
     */
    @PutMapping(value = "/api/order")
    void update(OrderDTO orderDTO) {

    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/api/order/{id}")
    void delete(@PathVariable("id") String id) {

    }
}
