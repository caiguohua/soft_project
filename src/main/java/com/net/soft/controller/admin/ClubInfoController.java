package com.net.soft.controller.admin;

import com.github.pagehelper.PageInfo;
import com.net.soft.exception.SoftException;
import com.net.soft.from.ClubInfoForm;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.service.ClubInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        List<ClubInfoDO> clubInfoList = clubInfoService.findAll(page,size);
        if(clubInfoList == null || clubInfoList.size() == 0){
            return new ModelAndView("admin/club/null");

        }
        PageInfo pageList = new PageInfo(clubInfoList);
        map.put("clubInfoList",pageList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/club/list",map);
    }

    /**
     * 展示
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/show")
    public ModelAndView show(@RequestParam(value = "id", required = false) Integer id,
                              Map<String, Object> map) {
        if (id != null) {
            ClubInfoDO clubInfoDO = clubInfoService.findOne(id);
            map.put("clubInfo", clubInfoDO);
        }
        return new ModelAndView("admin/club/update", map);
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id", required = false) Integer id,
                              Map<String, Object> map) {
        try {
            if (id != null) {
                clubInfoService.delete(id);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubInfo/list");
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/clubInfo/list");
        return new ModelAndView("admin/common/success", map);
    }


    /**
     * 更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/update")
    public ModelAndView update(@Valid ClubInfoForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubInfo/show");
            return new ModelAndView("admin/common/error", map);
        }

        ClubInfoDO clubInfoDO = new ClubInfoDO();
        try {
            if (form.getId() != null) {
                clubInfoDO = clubInfoService.findOne(form.getId());
            }
            BeanUtils.copyProperties(form, clubInfoDO);
            clubInfoService.update(clubInfoDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubInfo/show");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubInfo/list");
        return new ModelAndView("admin/common/success", map);
    }


    @GetMapping("/add")
    public ModelAndView add(Map<String, Object> map) {
        return new ModelAndView("admin/club/add", map);
    }


    @PostMapping("/insert")
    public ModelAndView add(@Valid ClubInfoForm form,
                               BindingResult bindingResult,
                               Map<String, Object> map) {
        if(form.getName() == null || form.getPhone() == null || form.getAddress() == null || form.getSequence() == null){
            map.put("msg", "参数输入不完整");
            map.put("url", "/soft/clubInfo/add");
            return new ModelAndView("admin/common/error", map);
        }
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubInfo/add");
            return new ModelAndView("admin/common/error", map);
        }

        ClubInfoDO clubInfoDO = new ClubInfoDO();
        try {
            BeanUtils.copyProperties(form, clubInfoDO);
            clubInfoService.add(clubInfoDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubInfo/add");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubInfo/list");
        return new ModelAndView("admin/common/success", map);
    }

}
