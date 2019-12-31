package com.yaqiwe.domain.mapper.mapperSql;

import com.yaqiwe.domain.dto.CatrDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:52
 * @Version 1.0
 */
@Slf4j
public class shopCartMapperSql {

    public String InsertCart(List<CatrDto> dto, Long cartId) {
        StringBuffer sql= new StringBuffer();
        sql.append("INSERT INTO ");
        sql.append("shop_cart ");
        sql.append("(cart_id,com_id,com_number) ");
        sql.append("VALUES ");
        for (int i = 0,j=dto.size(); i < j; i++) {
            CatrDto com=dto.get(i);
            sql.append("("+cartId+","+com.getComId()+","+com.getComNumber()+")");
            if(i<j-1){
                sql.append(",");
            }
        }
        sql.append("ON DUPLICATE KEY UPDATE com_number=VALUES(com_number)");
//        log.info("shopCartMapperSql SQL: {}",sql.toString());
        return sql.toString();
    }

    public String deleteCom(Long[] comId,Long cartId){
        StringBuffer sql= new StringBuffer();
        sql.append("DELETE FROM ");
        sql.append("shop_cart ");
        sql.append("WHERE cart_id = ");
        sql.append(cartId);
        sql.append(" AND com_id IN ( ");
        for (int i = 0,j=comId.length; i < j; i++) {
            sql.append(comId[i]);
            if(i<j-1){
                sql.append(" , ");
            }
        }
        sql.append(" )");
//        log.info("shopCartMapperSql SQL: {}",sql.toString());
        return sql.toString();
    }
}
