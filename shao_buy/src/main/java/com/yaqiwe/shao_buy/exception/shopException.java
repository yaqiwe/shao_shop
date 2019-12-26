package com.yaqiwe.shao_buy.exception;

import com.yaqiwe.shao_buy.enums.exceptionEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:47
 * @description：自定义的错误类型
 */
@Data
public class shopException extends RuntimeException {
    private Integer code;

    public shopException(exceptionEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }
}
