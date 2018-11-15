package me.mingshan.saga.api.account.service.hystrix;

import me.mingshan.saga.api.account.model.dto.UserDTO;
import me.mingshan.saga.api.account.model.vo.UserVO;
import me.mingshan.saga.api.account.service.AccountFeignApi;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignHystrix implements AccountFeignApi {
    @Override
    public UserVO getById(String id) {
        return null;
    }

    @Override
    public String save(UserDTO userDTO) {
        return null;
    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
