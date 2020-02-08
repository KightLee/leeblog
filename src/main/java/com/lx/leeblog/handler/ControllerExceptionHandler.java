package com.lx.leeblog.handler;

import com.lx.leeblog.util.ErrorCode;
import com.lx.leeblog.vo.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * create by @author lixing on 2020/1/27 22:17
 * 记录异常信息, 注射异常处理，效果还不如不加
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request,
                                        Exception e) {
        logger.error("RequestUrl , {}", request.getRequestURL(), e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        return mv;
    }

}
