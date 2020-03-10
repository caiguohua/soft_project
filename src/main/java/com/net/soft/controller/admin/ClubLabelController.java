package com.net.soft.controller.admin;

import com.net.soft.exception.SoftException;
import com.net.soft.from.ClubLabelForm;
import com.net.soft.model.ClubLabelDO;
import com.net.soft.service.ClubLabelService;
import com.net.soft.service.InfoLabelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2020/3/5 11:15
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/clubLabel")
public class ClubLabelController {

    private final ClubLabelService clubLabelService;
    private final InfoLabelService infoLabelService;

    @Autowired
    public ClubLabelController(ClubLabelService clubLabelService,InfoLabelService infoLabelService) {
        this.clubLabelService = clubLabelService;
        this.infoLabelService = infoLabelService;
    }


    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){

        List<ClubLabelDO> clubLabelList = clubLabelService.findAll();
        map.put("clubLabelList",clubLabelList);
        return new ModelAndView("admin/label/list",map);
    }


    @GetMapping("/findByCid")
    public ModelAndView findByCid(@RequestParam(value = "cid", required = false) Integer cid,
                             Map<String, Object> map){
        if(cid != null){
            List<ClubLabelDO> clubLabelList = clubLabelService.findByCid(cid);
            map.put("clubLabelList",clubLabelList);
            map.put("cid",cid);
        }
        return new ModelAndView("admin/label/oneList",map);
    }

    @GetMapping("/add")
    public ModelAndView add(Map<String, Object> map) {
        return new ModelAndView("admin/label/add", map);
    }


    /**
     * 给一个会所添加标签
     * @param cid
     * @param map
     * @return
     */
    @GetMapping("/addInfoLabel")
    public ModelAndView addInfoLabel(@RequestParam(value = "cid",required = false) Integer cid,
                                     Map<String, Object> map) {
        if (cid != null) {
            map.put("cid",cid);
            List<ClubLabelDO> clubLabelList = clubLabelService.findNotHasByCid(cid);
            if(clubLabelList != null || clubLabelList.size() > 0){
                if(clubLabelList.size() >= 3 ){
                    map.put("msg", "最多3个标签！请删除后再添加");
                    map.put("url", "/soft/clubInfo/list");
                    return new ModelAndView("admin/common/error", map);
                }
                map.put("clubLabelList", clubLabelList);
            }
        }
        return new ModelAndView("admin/label/addInfoLabel", map);
    }

    /**
     * 添加
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/insert")
    public ModelAndView add(@Valid ClubLabelForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map) {
        if(form.getName() == null){
            map.put("msg", "没有输入参数");
            map.put("url", "/soft/clubLabel/add");
            return new ModelAndView("admin/common/error", map);
        }
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubLabel/add");
            return new ModelAndView("admin/common/error", map);
        }

        ClubLabelDO clubLabelDO = new ClubLabelDO();
        try {
            BeanUtils.copyProperties(form, clubLabelDO);
            clubLabelService.add(clubLabelDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubLabel/add");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubProduct/list");
        return new ModelAndView("admin/common/success", map);
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
            ClubLabelDO clubLabelDO = clubLabelService.findById(id);
            map.put("clubLabel", clubLabelDO);
        }
        return new ModelAndView("admin/label/update", map);
    }


    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id", required = false) Integer id,
                               Map<String, Object> map) {
        try {
            if (id != null) {
                clubLabelService.delete(id);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubLabel/list");
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/clubLabel/list");
        return new ModelAndView("admin/common/success", map);
    }

    @GetMapping("/deleteInfoLabel")
    public ModelAndView deleteInfoLabel(@RequestParam(value = "cid", required = false) Integer cid,
                               @RequestParam(value = "lid",required = false) Integer lid,
                               Map<String, Object> map) {
        try {
            if (cid != null && lid != null) {
                infoLabelService.delete(cid,lid);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubLabel/findByCid?cid="+cid);
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/clubLabel/findByCid?cid="+cid);
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
    public ModelAndView update(@Valid ClubLabelForm form,
                               BindingResult bindingResult,
                               Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubLabel/show");
            return new ModelAndView("admin/common/error", map);
        }

        ClubLabelDO clubLabelDO = new ClubLabelDO();
        try {
            if (form.getId() != null) {
                clubLabelDO = clubLabelService.findById(form.getId());
            }
            BeanUtils.copyProperties(form, clubLabelDO);
            clubLabelService.update(clubLabelDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubLabel/show");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubLabel/list");
        return new ModelAndView("admin/common/success", map);
    }
    
}
