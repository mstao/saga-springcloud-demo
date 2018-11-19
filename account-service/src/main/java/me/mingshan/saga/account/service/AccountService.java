package me.mingshan.saga.account.service;

import me.mingshan.saga.api.account.model.dto.UserDTO;

public interface AccountService {
    UserDTO getById(Long id);
}
