package com.yaqiwe.domain.util;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 15:58
 * @description：
 */
public class UserIdUtil {
    private static generationId userId=new generationId(1,2);
    private static generationId cartId=new generationId(1,3);
    private static generationId addId=new generationId(2,1);

    /**
     * 生成userId
     * @return
     */
    public static long getUserId(){
        return userId.nextId();
    }

    /**
     * 生成购物车ID
     * @return
     */
    public static long getCartId(){
        return cartId.nextId();
    }

    /**
     * 生成地址的id
     * @return
     */
    public static long getAddId(){
        return addId.nextId();
    }
}
