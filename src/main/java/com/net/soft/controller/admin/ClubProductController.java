package com.net.soft.controller.admin;

import com.github.pagehelper.PageInfo;
import com.net.soft.converter.ClubProductDOtoProductDTOConverter;
import com.net.soft.exception.SoftException;
import com.net.soft.from.ClubProductForm;
import com.net.soft.model.ClubProductDO;
import com.net.soft.model.dto.ProductDTO;
import com.net.soft.service.ClubProductService;
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
 * @date 2020/3/5 20:09
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/clubProduct")
public class ClubProductController {
    private final ClubProductService clubProductService;

    @Autowired
    public ClubProductController(ClubProductService clubProductService) {
        this.clubProductService = clubProductService;
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "cid", required = false) Integer cid,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        List<ClubProductDO> clubProductList;
        if(cid != null){
            clubProductList = clubProductService.findByCid(cid, page, size);
        }else {
            clubProductList = clubProductService.findAll(page, size);
        }
        if(clubProductList == null || clubProductList.size() == 0){
            return new ModelAndView("admin/product/null");
        }
        List<ProductDTO> productDTOList = ClubProductDOtoProductDTOConverter.convert(clubProductList);


        PageInfo pageList = new PageInfo(productDTOList);
        map.put("clubProductList",pageList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/product/list",map);
    }


    @GetMapping("/add")
    public ModelAndView add(Map<String, Object> map) {
        return new ModelAndView("admin/product/add", map);
    }

    @PostMapping("/insert")
    public ModelAndView add(@Valid ClubProductForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map) {
        if(form.getCid() == null || form.getName() == null || form.getDesc() == null || form.getPrice() == null || form.getSum() == null){
            map.put("msg", "参数输入不完整");
            map.put("url", "/soft/clubProduct/add");
            return new ModelAndView("admin/common/error", map);
        }
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubProduct/add");
            return new ModelAndView("admin/common/error", map);
        }

        ClubProductDO clubProductDO = new ClubProductDO();
        try {
            BeanUtils.copyProperties(form, clubProductDO);
            clubProductService.add(clubProductDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubProduct/insert");
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
            ClubProductDO clubProductDO = clubProductService.findById(id);
            map.put("clubProduct", clubProductDO);
        }
        return new ModelAndView("admin/product/update", map);
    }


    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id", required = false) Integer id,
                               Map<String, Object> map) {
        try {
            if (id != null) {
                clubProductService.delete(id);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubProduct/list");
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/clubProduct/list");
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
    public ModelAndView update(@Valid ClubProductForm form,
                               BindingResult bindingResult,
                               Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/clubProduct/show");
            return new ModelAndView("admin/common/error", map);
        }

        ClubProductDO clubProductDO = new ClubProductDO();
        try {
            if (form.getId() != null) {
                clubProductDO = clubProductService.findById(form.getId());
            }
            BeanUtils.copyProperties(form, clubProductDO);
            clubProductService.update(clubProductDO);
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubProduct/show");
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/clubProduct/list");
        return new ModelAndView("admin/common/success", map);
    }

}
