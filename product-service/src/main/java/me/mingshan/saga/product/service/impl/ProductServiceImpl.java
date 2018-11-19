package me.mingshan.saga.product.service.impl;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.id.SnowflakeIdWorker;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.product.dao.ProductDao;
import me.mingshan.saga.product.entity.Product;
import me.mingshan.saga.product.service.ProductService;
import org.apache.servicecomb.saga.omega.transaction.annotations.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long save(ProductDTO productDTO) {
        Product product = orikaMapperFacade.map(productDTO, Product.class);
        product.setId(SnowflakeIdWorker.getInstance().nextId());
        productDao.insert(product);
        return product.getId();
    }

    @Compensable(timeout = 5000, compensationMethod = "cancelDecreaseStock")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseStock(Long id, Integer number) throws ServiceException {
        Product product = productDao.findById(id);
        if (product.getStock() < number) {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(11001);
            resultModel.setMessage("The stock is less than " + number);
            throw new ServiceException(resultModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        productDao.decreaseStock(id, number);
    }

    @Override
    public void increaseStock(Long id, Integer number) {

    }

    public void cancelDecreaseStock(Long id, Integer number) {
        System.out.println("Product.cancelDecreaseStock is called, id: " + id);
        productDao.increaseStock(id, number);
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
