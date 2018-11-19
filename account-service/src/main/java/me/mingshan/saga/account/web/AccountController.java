package me.mingshan.saga.account.web;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.account.service.AccountService;
import me.mingshan.saga.api.account.model.dto.UserDTO;
import me.mingshan.saga.api.account.model.vo.UserVO;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @GetMapping(value = "/api/account/{id}")
    public ResponseEntity<ResultModel> getById(@PathVariable("id") Long id) {
        UserDTO userDTO = accountService.getById(id);
        UserVO userVO = orikaMapperFacade.map(userDTO, UserVO.class);

        ResultModel<UserVO> resultModel = new ResultModel<>();
        resultModel.setCode(0L);
        resultModel.setContent(userVO);
        return new ResponseEntity<>(resultModel, HttpStatus.OK);
    }

}
