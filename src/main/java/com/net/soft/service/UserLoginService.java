package com.net.soft.service;

import com.net.soft.model.UserInfoDO;

import java.util.HashMap;

/**
 * @author yangdajiang
 * @date 2020/3/11 11:06
 * @Email:786742736@qq.com
 */
public interface UserLoginService {
    HashMap<String,UserInfoDO> userLogin(String userName, String password);
    String userRegister(String phone,String userName,String password);
}
