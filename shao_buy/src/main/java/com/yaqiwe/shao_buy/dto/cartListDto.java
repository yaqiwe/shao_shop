package com.yaqiwe.shao_buy.dto;

import com.yaqiwe.domain.dto.CatrDto;
import lombok.Data;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 17:59
 * @Version 1.0
 */
@Data
public class cartListDto {
   List<CatrDto> cartInfo;
}
