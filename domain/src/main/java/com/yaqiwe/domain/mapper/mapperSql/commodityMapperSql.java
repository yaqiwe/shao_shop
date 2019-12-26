package com.yaqiwe.domain.mapper.mapperSql;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 16:20
 * @description：
 */
@Slf4j
public class commodityMapperSql {

    public String findAllSql(String userId){
        return new SQL(){
            {
                SELECT("*");
                FROM("commodity");
                if(userId.trim().isEmpty()){    //todo  若userId则查询该用户是否收藏该商品
//                    LEFT_OUTER_JOIN()
                }
            }
        }.toString();
    }

    public String getComByComId(List<Long> comId){
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT * ");
        sql.append("FROM commodity ");
        sql.append("WHERE com_id in ( ");
        for (int i = 0,j=comId.size(); i < j; i++) {
            sql.append(comId.get(i));
            if(i<j-1){
                sql.append(" , ");
            }
        }
        sql.append(" )");
//        log.info("commodityMapperSql getComByComId : {}",sql.toString());
        return sql.toString();
    }
}
