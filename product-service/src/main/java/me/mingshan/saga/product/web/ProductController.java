package me.mingshan.saga.product.web;

import com.sun.javafx.binding.StringFormatter;
import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.common.util.ExceptionUtil;
import me.mingshan.saga.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @Autowired
    private MapperFacade orikaMapperFacade;

    /**
     * Gets product by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResultModel<ProductVO>> getById(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.getById(id);
        ProductVO productVO = orikaMapperFacade.map(productDTO, ProductVO.class);

        ResultModel<ProductVO> resultModel = new ResultModel();
        resultModel.setCode(0L);
        resultModel.setContent(productVO);

        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     * Saves product
     *
     * @param productDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<ResultModel<Long>> save(@RequestBody ProductDTO productDTO) {
        LOGGER.info("Processing save product: {}", productDTO);
        Long id = productService.save(productDTO);
        ResultModel<Long> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(id);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     *
     * @param productDTO
     */
    @PutMapping
    public void update(ProductDTO productDTO) {

    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {

    }

    @PutMapping(value = "/decreaseStock")
    public void decreaseStock(@RequestParam("id") Long id,
                              @RequestParam("number") int number) {
        productService.decreaseStock(id, number);
    }

}
