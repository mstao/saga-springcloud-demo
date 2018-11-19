package me.mingshan.saga.product.service;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.common.base.exception.ServiceException;

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
     * Decrease the stock.
     *
     * @param id
     * @param number
     */
    void decreaseStock(Long id, Integer number) throws ServiceException;

    void increaseStock(Long id, Integer number);

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
