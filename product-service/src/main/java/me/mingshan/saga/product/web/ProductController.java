package me.mingshan.saga.product.web;

import com.sun.javafx.binding.StringFormatter;
import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.api.product.model.dto.ProductDTO;
import me.mingshan.saga.api.product.model.vo.ProductVO;
import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import me.mingshan.saga.common.util.ExceptionUtil;
import me.mingshan.saga.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

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
    @PostMapping()
    public ResponseEntity<ResultModel<Long>> save(ProductDTO productDTO) {
        Long id;
        try {
            id = productService.save(productDTO);
        } catch (Exception e) {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(10003L);
            resultModel.setMessage("Save product: " + productDTO + ", occurs error, reason: " + ExceptionUtil.getFullStackTrace(e));
            throw new ServiceException(resultModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResultModel<Long> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(id);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

    /**
     *
     * @param productDTO
     */
    @PutMapping()
    public void update(ProductDTO productDTO) {

    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {

    }

}
