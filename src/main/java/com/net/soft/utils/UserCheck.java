package com.net.soft.utils;

import com.net.soft.mapper.UserInfoMapper;
import com.net.soft.model.UserInfoDO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 判断用户名数据库中是否存在
 * @author yangdajiang
 * @date 2020/3/10 22:22
 * @Email:786742736@qq.com
 */

@Component
public class UserCheck {

    private static UserCheck userCheck;

    @Resource
    private UserInfoMapper userInfoMapper;

    @PostConstruct
    public void init() {
        userCheck = this;
        userCheck.userInfoMapper = this.userInfoMapper;
    }

    public static boolean userIsExist(String userName){
        UserInfoDO userInfoDO  = userCheck.userInfoMapper.getUserInfoByName(userName);

        if(userInfoDO == null){
            return false;
        }
        return true;
    }

    public static int userType(String userName){
        UserInfoDO userInfoDO  = userCheck.userInfoMapper.getUserInfoByName(userName);
        return userInfoDO.getType();
    }


}
