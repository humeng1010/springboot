package com.red.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller的异常处理器
 */
//@ControllerAdvice
@RestControllerAdvice//REST风格
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doException(Exception exception){
        exception.printStackTrace();
        return new R(false,"*_*发生异常: "+exception);
    }
}
