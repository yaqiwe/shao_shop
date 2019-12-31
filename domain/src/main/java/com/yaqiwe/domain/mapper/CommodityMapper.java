package com.yaqiwe.domain.mapper;

import com.github.pagehelper.Page;
import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.mapper.mapperSql.commodityMapperSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 15:02
 * @description：商品信息数据库操作
 */
@Mapper
@Component("CommodityMapper")
public interface CommodityMapper {

    /*插入数据*/
    @Insert("insert into commodity(com_id,com_name,com_describe,com_src,com_price,com_stock,show_src,details_src)" +
            " values (#{comId},#{comName},#{comDescribe},#{comSrc},#{comPrice},#{comStock},#{showSrc},#{detailsSrc})")
    int insertCom(commodity com);

    @Select("SELECT * FROM commodity ORDER BY com_id DESC")
    Page<commodity> fandAll();

    @Select("SELECT * FROM commodity Where com_id = #{comId}")
    commodity findById(long comId);

    @SelectProvider(type = commodityMapperSql.class, method = "getComByComId")
    List<commodity> getComByComId(@Param("comId") List<Long> comId);
}
