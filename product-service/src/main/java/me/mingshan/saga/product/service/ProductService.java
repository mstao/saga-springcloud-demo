package me.mingshan.saga.product.service;

import me.mingshan.saga.api.product.model.dto.ProductDTO;

/**
 * @author mingshan
 */
public interface ProductService {
    /**
     * Gets product by id.
     *
     * @param id
     * @return
     */
    ProductDTO getById(Long id);

    /**
     * Saves product
     *
     * @param productDTO
     * @return
     */
    Long save(ProductDTO productDTO);

    /**
     *
     * @param productDTO
     */
    void update(ProductDTO productDTO);

    /**
     *
     * @param id
     */
    void delete(Long id);
}
