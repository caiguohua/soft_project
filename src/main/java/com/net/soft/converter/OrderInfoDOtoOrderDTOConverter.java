package com.net.soft.converter;

import com.net.soft.model.OrderInfoDO;
import com.net.soft.model.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caiguohua
 * @date 2020/3/9 16:19
 * @Email:cai.beyond@qq.com
 */
public class OrderInfoDOtoOrderDTOConverter {
    public static OrderDTO convert(OrderInfoDO orderInfoDO) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderInfoDO, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderInfoDO> orderInfoDOList) {
        return orderInfoDOList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
