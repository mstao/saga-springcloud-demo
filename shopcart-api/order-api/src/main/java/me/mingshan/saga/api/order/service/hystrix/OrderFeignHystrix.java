package me.mingshan.saga.api.order.service.hystrix;

import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.api.order.service.OrderFeignApi;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author mingshan
 */
@Component
public class OrderFeignHystrix implements OrderFeignApi {

    @Override
    public ResponseEntity<ResultModel<OrderVO>> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResultModel<OrderVO>> getByUserId(long userId) {
        return null;
    }

    @Override
    public ResponseEntity<ResultModel<Long>> save(OrderDTO orderDTO) throws ServiceException {
        return null;
    }

    @Override
    public void update(OrderDTO orderDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
