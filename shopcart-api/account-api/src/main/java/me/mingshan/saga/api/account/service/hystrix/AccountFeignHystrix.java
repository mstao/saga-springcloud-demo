package me.mingshan.saga.api.account.service.hystrix;

import me.mingshan.saga.api.account.model.dto.UserDTO;
import me.mingshan.saga.api.account.model.vo.UserVO;
import me.mingshan.saga.api.account.service.AccountFeignApi;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignHystrix implements AccountFeignApi {

    @Override
    public ResponseEntity<ResultModel<UserVO>> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResultModel<Long>> save(UserDTO userDTO) {
        return null;
    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
