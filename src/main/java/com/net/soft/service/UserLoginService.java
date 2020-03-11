package com.net.soft.service;

import com.net.soft.model.UserInfoDO;

/**
 * @author yangdajiang
 * @date 2020/3/11 11:06
 * @Email:786742736@qq.com
 */
public interface UserLoginService {
    String userLogin(String userName,String password);
    String userRegister(String phone,String userName,String password);
}
