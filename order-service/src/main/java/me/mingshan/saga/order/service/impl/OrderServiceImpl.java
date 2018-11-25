package me.mingshan.saga.order.service.impl;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.account.model.vo.UserVO;
import me.mingshan.saga.api.account.service.AccountFeignApi;
import me.mingshan.saga.api.order.enums.OrderStatus;
import me.mingshan.saga.api.order.model.dto.OrderDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.api.product.service.ProductFeignApi;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.id.SnowflakeIdWorker;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.order.dao.OrderDao;
import me.mingshan.saga.order.entity.Order;
import me.mingshan.saga.order.service.GenerateOrderNumber;
import me.mingshan.saga.order.service.OrderService;
import me.mingshan.saga.order.util.OrderStatusUtil;
import org.apache.servicecomb.saga.omega.context.annotations.SagaStart;
import org.apache.servicecomb.saga.omega.transaction.annotations.Compensable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GenerateOrderNumber generateOrderNumber;

    @Autowired
    private ProductFeignApi productFeignApi;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Autowired
    private AccountFeignApi accountFeignApi;

    @Override
    public OrderDTO getById(Long id) {
        Order order = orderDao.findById(id);
        OrderDTO orderDTO = orikaMapperFacade.map(order, OrderDTO.class);
        orderDTO.setStatus(OrderStatusUtil.getOrderStatusFormCode(order.getStatus()));
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getByUserId(Long userId) {
        ResponseEntity<ResultModel<UserVO>> userResponseEntity = accountFeignApi.getById(userId);
        ResultModel<UserVO> userVOResultModel = userResponseEntity.getBody();
        UserVO userVO = userVOResultModel.getContent();
        if (userVO == null) {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(12001);
            resultModel.setMessage("The user: " + userId + "is not existed");
            throw new ServiceException(resultModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Order> orders = orderDao.findByUserId(userId);
        return orikaMapperFacade.mapAsList(orders, OrderDTO.class);
    }

    @SagaStart(timeout = 6000)
    @Compensable(timeout = 5000, compensationMethod = "cancel")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long save(OrderDTO orderDTO) throws ServiceException {
        ResultModel resultModel = new ResultModel();
        ResponseEntity<ResultModel<UserVO>> userResponseEntity = accountFeignApi.getById(orderDTO.getUserId());
        ResultModel<UserVO> userVOResultModel = userResponseEntity.getBody();
        UserVO userVO = userVOResultModel.getContent();
        if (userVO == null) {
            resultModel.setCode(12001);
            resultModel.setMessage("The user: " + orderDTO.getUserId() + "is not existed");
            throw new ServiceException(resultModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResponseEntity<ResultModel<ProductVO>> responseEntity = productFeignApi.getById(orderDTO.getProductId());
        ResultModel<ProductVO> productResultModel = responseEntity.getBody();
        ProductVO productVO = productResultModel.getContent();

        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setProductId(orderDTO.getProductId());
        order.setId(SnowflakeIdWorker.getInstance().nextId());
        order.setNumber(generateOrderNumber.generate());
        order.setStatus(OrderStatus.PROCESSING.getCode());
        order.setPrice(productVO.getPrice());
        orderDao.insert(order);
        // pay ...
        // Decrease stock
        productFeignApi.decreaseStock(order.getProductId(), 1);

        throw new IllegalArgumentException("参数错误");
        //return order.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public Long cancel(OrderDTO orderDTO)  throws ServiceException {
        LOGGER.info("Order.cancel executed , data: {}", orderDTO);
        //orderDao.delete();
        return 0L;
    }

    @Override
    public void update(OrderDTO orderDTO) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }
}
