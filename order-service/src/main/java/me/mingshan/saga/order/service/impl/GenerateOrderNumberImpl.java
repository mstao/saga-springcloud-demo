package me.mingshan.saga.order.service.impl;

import me.mingshan.saga.order.service.GenerateOrderNumber;
import org.springframework.stereotype.Service;

@Service
public class GenerateOrderNumberImpl implements GenerateOrderNumber {

    @Override
    public String generate() {
        return "123456";
    }
}
