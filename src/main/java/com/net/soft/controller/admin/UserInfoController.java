package com.net.soft.controller.admin;

import com.github.pagehelper.PageInfo;
import com.net.soft.converter.UserInfoDOtoUserDTOConverter;
import com.net.soft.exception.SoftException;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.model.UserInfoDO;
import com.net.soft.model.dto.UserDTO;
import com.net.soft.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author caiguohua
 * @date 2020/3/8 17:48
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        List<UserInfoDO> userInfoList = userInfoService.findAll(page,size);
        if(userInfoList == null || userInfoList.size() == 0){
            return new ModelAndView("admin/user/null");
        }
        List<UserDTO> userDTOList = UserInfoDOtoUserDTOConverter.convert(userInfoList);
        PageInfo pageList = new PageInfo(userDTOList);
        map.put("userInfoList",pageList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/user/list",map);
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id", required = false) Integer id,
                               Map<String, Object> map) {
        try {
            if (id != null) {
                userInfoService.delete(id);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/userInfo/list");
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/userInfo/list");
        return new ModelAndView("admin/common/success", map);
    }

}
