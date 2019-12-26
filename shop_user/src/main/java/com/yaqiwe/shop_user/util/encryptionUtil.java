package com.yaqiwe.shop_user.util;

import org.springframework.util.DigestUtils;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 1:42
 * @Version 1.0
 * 加密密码的算法
 */
public class encryptionUtil {

    private static String HASH_NAME="MD5";

    private static int HASH_NUMBER=15;

    /**
     * 加密
     * @param passWore 加密的密码
     * @param salt 加密的盐
     * @return
     */
    public static String encryption(String passWore, String salt){
        String hash_String=passWore;
        for (int i = 0; i < HASH_NUMBER; i++) {
            hash_String= DigestUtils.md5DigestAsHex(hash_String.getBytes());
        }
        return hash_String;
    }
}
