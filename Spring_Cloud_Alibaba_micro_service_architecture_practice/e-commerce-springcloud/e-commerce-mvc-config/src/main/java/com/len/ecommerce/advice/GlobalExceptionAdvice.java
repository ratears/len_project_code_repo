package com.len.ecommerce.advice;

import com.len.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常统一捕获处理</h1>
 */
@Slf4j
@RestControllerAdvice(value = "com.len.ecommerce")
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(HttpServletRequest req,Exception ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());
        log.info("commerce service has error: [{}]",ex.getMessage(),ex);
        return  response;
    }
}
