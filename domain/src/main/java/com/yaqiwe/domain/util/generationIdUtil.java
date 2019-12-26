package com.yaqiwe.domain.util;

import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 14:45
 * @description：
 */
@Service
public class generationIdUtil {
    private static final generationId id=new generationId(1,1);

    public static long getId(){
        return id.nextId();
    }
}
