package me.mingshan.saga.order.service.impl;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.order.enums.OrderStatus;
import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.common.base.id.SnowflakeIdWorker;
import me.mingshan.saga.order.dao.OrderDao;
import me.mingshan.saga.order.entity.Order;
import me.mingshan.saga.order.service.GenerateOrderNumber;
import me.mingshan.saga.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GenerateOrderNumber generateOrderNumber;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Override
    public OrderDTO getById(Long id) {
        Order order = orderDao.findById(id);
        OrderDTO orderDTO = orikaMapperFacade.map(order, OrderDTO.class);
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getByUserId(Long userId) {
        List<Order> orders = orderDao.findByUserId(userId);
        List<OrderDTO> orderDTOS = orikaMapperFacade.mapAsList(orders, OrderDTO.class);
        return orderDTOS;
    }

    @Override
    public Long save(OrderDTO orderDTO) {
        Order order = orikaMapperFacade.map(orderDTO, Order.class);
        order.setId(SnowflakeIdWorker.getInstance().nextId());
        order.setNumber(generateOrderNumber.generate());
        order.setStatus(OrderStatus.PROCESSING.getCode());
        orderDao.insert(order);
        return order.getId();
    }

    @Override
    public void update(OrderDTO orderDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
