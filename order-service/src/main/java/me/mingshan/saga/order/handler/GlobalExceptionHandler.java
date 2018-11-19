package me.mingshan.saga.order.handler;

import me.mingshan.saga.common.base.exception.ServiceException;
import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.rmi.ServerException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ResultModel> handleServiceException(ServiceException ex) {
        return new ResponseEntity<>(ex.getResult(), ex.getHttpStatus());
    }
}