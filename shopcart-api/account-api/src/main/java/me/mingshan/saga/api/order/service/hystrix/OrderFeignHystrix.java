package me.mingshan.saga.api.order.service.hystrix;

import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.api.order.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mingshan
 */
@Component
public class OrderFeignHystrix implements OrderService {
    @Override
    public OrderVO getById(String id) {
        return null;
    }

    @Override
    public List<OrderVO> getByUserId(String userId) {
        return null;
    }

    @Override
    public String save(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void update(OrderDTO orderDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
