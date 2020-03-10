package com.net.soft.converter;

import com.net.soft.model.OrderInfoDO;
import com.net.soft.model.UserInfoDO;
import com.net.soft.model.dto.OrderDTO;
import com.net.soft.model.dto.UserDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caiguohua
 * @date 2020/3/9 16:42
 * @Email:cai.beyond@qq.com
 */
public class UserInfoDOtoUserDTOConverter {
    public static UserDTO convert(UserInfoDO userInfoDO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfoDO, userDTO);
        return userDTO;
    }

    public static List<UserDTO> convert(List<UserInfoDO> userInfoDOList) {
        return userInfoDOList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
