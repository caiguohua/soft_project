package com.net.soft.service.impl;

import com.net.soft.mapper.UserInfoMapper;
import com.net.soft.model.UserInfoDO;
import com.net.soft.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;

import static com.net.soft.utils.UserCheck.userIsExist;

/**
 * @author yangdajiang
 * @date 2020/3/11 11:06
 * @Email:786742736@qq.com
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public HashMap<String,UserInfoDO> userLogin(String userName, String password) {
        HashMap<String,UserInfoDO> map = new HashMap<>(10);
        if (!userIsExist(userName)){
            map.put("error",null);
            return map;
        }
        UserInfoDO userInfoDO = userInfoMapper.getUserInfoByName(userName);
        if(userInfoDO.getPassword().equals(password)){
            map.put("success",userInfoDO);
            return map;
        }
        else {
            map.put("error",null);
            return map;
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
                userInfoDO.setType(0);

                userInfoMapper.insertData(userInfoDO);
                return "注册成功";
            }else {
                return "不能为空";
            }
        }
    }
}
