package com.shencangblue.design.icrs.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    public void defaultErrorHandler(HttpServletRequest req, Exception e)  {
        //打印异常信息：
        e.printStackTrace();
        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
    }
}
