package me.mingshan.saga.product.service.impl;

import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author mingshan
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowried
    private ProductDao productDao;

    @Override
    public ProductVO getById(String id) {
        return pro;
    }

    @Override
    public String save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
