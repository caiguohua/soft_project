package com.net.soft.controller.admin;

import com.net.soft.exception.SoftException;
import com.net.soft.from.InfoLabelForm;
import com.net.soft.model.InfoLabelDO;
import com.net.soft.service.InfoLabelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author caiguohua
 * @date 2020/3/7 16:51
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/infoLabel")
public class InfoLabelController {
    private final InfoLabelService infoLabelService;

    @Autowired
    public InfoLabelController(InfoLabelService infoLabelService) {
        this.infoLabelService = infoLabelService;
    }

    @PostMapping("/insert")
    public ModelAndView insert(@Valid InfoLabelForm form,
                       BindingResult bindingResult,
                       Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/infoLabel/insert");
            return new ModelAndView("admin/common/error", map);
        }

        InfoLabelDO infoLabelDO = new InfoLabelDO();
        try {
            BeanUtils.copyProperties(form, infoLabelDO);
            infoLabelService.insert(infoLabelDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/infoLabel/insert");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubLabel/findByCid?cid="+infoLabelDO.getCid());
        return new ModelAndView("admin/common/success", map);
    }
}
