package com.internet.jiaowuxitong.common.handler;


import com.internet.jiaowuxitong.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
//全局异常处理
@ControllerAdvice
public class Globalexceptionhandler {

    //指定异常执行方法
    @ExceptionHandler(ArithmeticException.class)
    //为了返回数据
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("方法执行ArithmeticException异常！");
    }

    //自定义的异常处理
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
