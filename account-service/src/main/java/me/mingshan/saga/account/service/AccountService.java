package me.mingshan.saga.account.service;

import me.mingshan.saga.account.entity.User;
import me.mingshan.saga.api.account.model.dto.UserDTO;
import me.mingshan.saga.common.base.exception.ServiceException;

public interface AccountService {
    UserDTO getById(Long id);
    Long insert(UserDTO user) throws ServiceException;
}
