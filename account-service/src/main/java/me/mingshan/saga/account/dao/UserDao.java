package me.mingshan.saga.account.dao;

import me.mingshan.saga.account.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findById(Long id);
}
