package com.yaqiwe.shop_user.service;

import com.yaqiwe.domain.entity.user;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 16:05
 * @description：用户操作service
 */
@Validated
public interface userService {

    /**
     * 用户注册
     * @param userName
     * @param passWord
     * @return
     */
    void registered(@NotBlank(message = "用户名不能为空") String userName,
                    @NotBlank(message = "密码不能为空") String passWord);

    /**
     * 登录
     * @param userName
     * @param passWord
     */
    user logIn(@NotBlank(message = "用户名不能为空") String userName,
               @NotBlank(message = "密码不能为空") String passWord);
}
