package me.mingshan.saga.common.base.exception;

import me.mingshan.saga.common.base.model.ResultModel;
import org.springframework.http.HttpStatus;

/**
 * @author mingshan
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 3864528949793093768L;

    private ResultModel result;
    private HttpStatus httpStatus;

    public ServiceException() { }

    public ServiceException(ResultModel result, HttpStatus httpStatus) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public ResultModel getResult() {
        return this.result;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
