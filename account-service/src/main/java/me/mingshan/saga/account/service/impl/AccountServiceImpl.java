package me.mingshan.saga.account.service.impl;

import ma.glasnost.orika.MapperFacade;
import me.mingshan.saga.account.dao.UserDao;
import me.mingshan.saga.account.entity.User;
import me.mingshan.saga.account.service.AccountService;
import me.mingshan.saga.api.account.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Override
    public UserDTO getById(Long id) {
        User user = userDao.findById(id);
        UserDTO userDTO = orikaMapperFacade.map(user, UserDTO.class);
        return userDTO;
    }
}
