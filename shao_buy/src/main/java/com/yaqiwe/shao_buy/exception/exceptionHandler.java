package com.yaqiwe.shao_buy.exception;

import com.yaqiwe.shao_buy.enums.exceptionEnum;
import com.yaqiwe.shao_buy.util.Resoult;
import com.yaqiwe.shao_buy.util.ResoultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:50
 * @description：异常拦截
 */
@ResponseBody
@ControllerAdvice
public class exceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resoult errorHandler(Exception e) {
        /*自定义的错误类型*/
        if (e instanceof shopException) {
            shopException ce = (shopException) e;
            return ResoultUtil.error(ce.getCode(), ce.getMessage());
        }
        //其他异常，打印控制台
        e.printStackTrace();
        return ResoultUtil.error(exceptionEnum.UNKNOWN_ERROR);
    }

    /**
     * 参数校验
     * @param
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Resoult handleBindGetException(ConstraintViolationException ex){
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return  ResoultUtil.error(exceptionEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
    }
}
