package com.emarket.market.exception;

import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    @ExceptionHandler(UserNotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseVo userNotLogin(UserNotLoginException e){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
