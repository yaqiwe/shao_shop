package com.yaqiwe.domain.mapper;


import com.yaqiwe.domain.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 15:41
 * @description：用户表数据库操作
 */
@Mapper
@Component("userMapper")
public interface userMapper {

    @Insert("insert into user (user_id,user_name,pass_word,shop_cart_id,save)" +
            "values(#{userId},#{userName},#{passWord},#{shopCartId},#{save})")
    int insertUser(user us);

    @Select("select * from user where user_name=#{userName}")
    user findByUserName(String userName);
}
