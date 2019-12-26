package com.ysqiwe.commodity.util;

import com.ysqiwe.commodity.enums.exceptionEnum;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 17:10
 * @description：
 */
public class exceptioParsing {


    public static Resoult handleBindGetException(ConstraintViolationException ex){
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return  ResoultUtil.error(exceptionEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
    }

}
