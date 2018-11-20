package me.mingshan.saga.order.service.impl;

import me.mingshan.saga.order.service.GenerateOrderNumber;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenerateOrderNumberImpl implements GenerateOrderNumber {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
