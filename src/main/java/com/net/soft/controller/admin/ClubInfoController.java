package com.net.soft.controller.admin;

import com.net.soft.model.ClubInfoDO;
import com.net.soft.service.ClubInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author caiguohua
 * @date 2020/3/5 10:59
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/clubInfo")
public class ClubInfoController {

    private final ClubInfoService clubInfoService;

    @Autowired
    public ClubInfoController(ClubInfoService clubInfoService) {
        this.clubInfoService = clubInfoService;
    }

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map) {
        List<ClubInfoDO> clubInfoList = clubInfoService.findAll();
        map.put("clubInfoList",clubInfoList);
        return new ModelAndView("admin/club/list",map);
    }
}
