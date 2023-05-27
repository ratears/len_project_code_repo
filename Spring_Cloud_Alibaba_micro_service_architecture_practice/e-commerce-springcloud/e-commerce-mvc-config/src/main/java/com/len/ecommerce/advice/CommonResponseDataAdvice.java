package com.len.ecommerce.advice;

import com.len.ecommerce.annotation.IgnoreAnnotationAdvice;
import com.len.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应</h1>
 */
@RestControllerAdvice(value = "com.len.ecommerce")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    /**
     *<h1>判断是否需要对响应进行处理</h1>
     * @param returnType the return type
     * @param converterType the selected converter type
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {

        if(returnType.getMethod().isAnnotationPresent(IgnoreAnnotationAdvice.class)){
            return false;
        }
        if(returnType.getDeclaringClass().isAnnotationPresent(IgnoreAnnotationAdvice.class)){
            return false;
        }

        return true;
    }

    /**
     * <h1>包装响应体</h1>
     * @param body the body to be written
     * @param returnType the return type of the controller method
     * @param selectedContentType the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request the current request
     * @param response the current response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        CommonResponse<Object> res = new CommonResponse<Object>(0,"");

        if(null == body) {
            return body;
        }else if (body instanceof CommonResponse){
            res = (CommonResponse<Object>) body;
        }else {
            res.setData(body);
        }
        return res;
    }
}
