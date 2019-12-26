package com.yaqiwe.domain.mapper;

import com.yaqiwe.domain.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 9:28
 * @Version 1.0
 * 地址信息数据库操作
 */
@Mapper
public interface AddressMapper {

    /*添加收货地址*/
    @Insert("INSERT INTO address(user_id,add_id,user_adderss) values (#{userId},#{addId},#{userAdderss})")
    public int insertAddress(Address address);

    @Select("SELECT * FROM address WHERE user_id=#{userId}")
    public List<Address> getAddress(long userId);
}
