package me.mingshan.saga.api.product.service.hystrix;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.api.product.service.ProductFeignApi;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.http.ResponseEntity;

public class ProductFeignHystrix implements ProductFeignApi {

    @Override
    public ResponseEntity<ResultModel<ProductVO>> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResultModel<Long>> save(ProductDTO productDTO) throws ServiceException {
        return null;
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void decreaseStock(Long id, Integer number) throws ServiceException {

    }
}
