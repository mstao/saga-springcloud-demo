package me.mingshan.saga.api.product.service;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.api.product.service.hystrix.ProductFeignHystrix;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "product-service", fallback = ProductFeignHystrix.class)
public interface ProductFeignApi {
    /**
     * Gets product by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/api/product/{id}")
    ResponseEntity<ResultModel<ProductVO>> getById(@PathVariable("id") Long id);

    /**
     * Saves product
     *
     * @param productDTO
     * @return
     */
    @PostMapping(value = "/api/product")
    ResponseEntity<ResultModel<Long>> save(ProductDTO productDTO);

    /**
     *
     * @param productDTO
     */
    @PutMapping(value = "/api/product")
    void update(ProductDTO productDTO);

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/api/product/{id}")
    void delete(@PathVariable("id") Long id);

    @PutMapping(value = "/api/product/decreaseStock")
    void decreaseStock(Long id, Integer number);
}
