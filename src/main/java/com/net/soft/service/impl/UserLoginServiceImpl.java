package com.net.soft.service.impl;

import com.net.soft.mapper.UserInfoMapper;
import com.net.soft.model.UserInfoDO;
import com.net.soft.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.net.soft.utils.UserCheck.userIsExist;

/**
 * @author yangdajiang
 * @date 2020/3/11 11:06
 * @Email:786742736@qq.com
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserLoginServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public String userLogin(String userName,String password) {
        if (!userIsExist(userName)){
            return "用户名不存在";
        }
        if(userInfoMapper.getUserInfoByName(userName)
                .getPassword()
                .equals(password)){
            return "登陆成功";
        }
        else {
            return "密码错误";
        }
    }

    @Override
    public String userRegister(String phone,String userName,String password) {
        boolean isExist = userIsExist(userName);
        if(isExist){
            return "用户名已存在";
        }else {
            if(phone!=null||
                    userName!=null||
                    password!=null){
                UserInfoDO userInfoDO = new UserInfoDO();
                userInfoDO.setName(userName);
                userInfoDO.setPhone(phone);
                userInfoDO.setPassword(password);
                userInfoDO.setType(2);

                userInfoMapper.insertData(userInfoDO);
                return "注册成功";
            }else {
                return "不能为空";
            }
        }
    }
}
