package me.mingshan.saga.api.product.service.hystrix;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.api.product.service.ProductFeignApi;

public class ProductFeignHystrix implements ProductFeignApi {

    @Override
    public ProductVO getById(Long id) {
        return null;
    }

    @Override
    public Long save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
