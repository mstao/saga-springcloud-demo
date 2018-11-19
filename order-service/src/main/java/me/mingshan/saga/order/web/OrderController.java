package me.mingshan.saga.order.web;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.order.model.vo.OrderVO;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.common.util.ExceptionUtil;
import me.mingshan.saga.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResultModel<OrderVO>> getById(@PathVariable("id") Long id) {
        OrderDTO orderDTO = orderService.getById(id);
        OrderVO orderVo = orikaMapperFacade.map(orderDTO, OrderVO.class);
        orderVo.setStatus(orderDTO.getStatus());

        ResultModel<OrderVO> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(orderVo);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     * Gets orders by user id.
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/order/getByUserId/{userId}")
    public ResponseEntity<ResultModel<List<OrderVO>>> getByUserId(@PathVariable("userId") Long userId) {
        List<OrderDTO> orderDTOS = orderService.getByUserId(userId);
        List<OrderVO> orderVOS = orikaMapperFacade.mapAsList(orderDTOS, OrderVO.class);

        ResultModel<List<OrderVO>> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(orderVOS);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     * Saves order
     *
     * @param orderDTO
     * @return
     */
    @PostMapping(value = "/api/order")
    public ResponseEntity<ResultModel<Long>> save(OrderDTO orderDTO) {
        Long id = 0L;
        try {
            id = orderService.save(orderDTO);
        } catch (Exception e) {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(10003L);
            resultModel.setMessage("Save product: " + orderDTO + ", occurs error, reason: " + ExceptionUtil.getFullStackTrace(e));
            throw new ServiceException(resultModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResultModel<Long> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(id);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     *
     * @param orderDTO
     */
    @PutMapping(value = "/api/order")
    public void update(OrderDTO orderDTO) {

    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/api/order/{id}")
    public void delete(@PathVariable("id") String id) {

    }
}
