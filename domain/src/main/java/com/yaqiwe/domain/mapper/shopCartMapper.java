package com.yaqiwe.domain.mapper;

import com.yaqiwe.domain.dto.CatrDto;
import com.yaqiwe.domain.mapper.mapperSql.shopCartMapperSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:46
 * @Version 1.0
 * 购物车操作
 */
@Mapper
public interface shopCartMapper {

    /*插入数据，如果数据存在则修改商品的数量*/
    @InsertProvider(type = shopCartMapperSql.class ,method = "InsertCart")
    int insertCart(List<CatrDto> dto,Long cartId) ;

    @Select("SELECT * FROM shop_cart WHERE cart_id = #{cartId}")
    List<CatrDto> getCartCom(Long cartId);

    /*删除购物车商品*/
    @DeleteProvider(type = shopCartMapperSql.class ,method = "deleteCom")
    int deleteComm(Long[] comId,Long cartId);
}
