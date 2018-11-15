package me.mingshan.saga.api.product.service;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.api.product.service.hystrix.ProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "product-service", fallback = ProductFeignHystrix.class)
public interface ProductFeignApi {
    /**
     * Gets product by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/api/product/{id}")
    ProductVO getById(@PathVariable("id") String id);

    /**
     * Saves product
     *
     * @param productDTO
     * @return
     */
    @PostMapping(value = "/api/product")
    String save(ProductDTO productDTO);

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
    void delete(@PathVariable("id") String id);
}
