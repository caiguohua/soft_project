package com.net.soft.converter;

import com.net.soft.model.ClubProductDO;
import com.net.soft.model.dto.ProductDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caiguohua
 * @date 2020/3/9 15:07
 * @Email:cai.beyond@qq.com
 */
public class ClubProductDOtoProductDTOConverter {
    public static ProductDTO convert(ClubProductDO clubProductDO) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(clubProductDO, productDTO);
        return productDTO;
    }

    public static List<ProductDTO> convert(List<ClubProductDO> clubProductDOList) {
        return clubProductDOList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
