package me.mingshan.saga.product.service.impl;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.common.base.id.SnowflakeIdWorker;
import me.mingshan.saga.product.dao.ProductDao;
import me.mingshan.saga.product.entity.Product;
import me.mingshan.saga.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mingshan
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Override
    public ProductDTO getById(Long id) {
        Product product = productDao.findById(id);
        return orikaMapperFacade.map(product, ProductDTO.class);
    }

    @Override
    public Long save(ProductDTO productDTO) {
        Product product = orikaMapperFacade.map(productDTO, Product.class);
        product.setId(SnowflakeIdWorker.getInstance().nextId());
        productDao.insert(product);
        return product.getId();
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
