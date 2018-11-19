package me.mingshan.saga.api.account.service;

import me.mingshan.saga.api.account.model.dto.UserDTO;
import me.mingshan.saga.api.account.model.vo.UserVO;
import me.mingshan.saga.api.account.service.hystrix.AccountFeignHystrix;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "account-service", fallback = AccountFeignHystrix.class)
public interface AccountFeignApi {
    /**
     * Gets account by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/api/account/{id}")
    ResponseEntity<ResultModel<UserVO>> getById(@PathVariable("id") Long id);

    /**
     * Saves account
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/api/account")
    ResponseEntity<ResultModel<Long>> save(@RequestBody UserDTO userDTO);

    /**
     *
     * @param userDTO
     */
    @PutMapping(value = "/api/account")
    void update(@RequestBody UserDTO userDTO);

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/api/account/{id}")
    void delete(@PathVariable("id") Long id);
}
