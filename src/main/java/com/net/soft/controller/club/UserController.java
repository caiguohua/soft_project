package com.net.soft.controller.club;

import com.net.soft.exception.SoftException;
import com.net.soft.from.ClubCommentForm;
import com.net.soft.model.ClubCommentsDO;
import com.net.soft.service.ClubCommentsService;
import com.net.soft.service.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;

/**
 * @author caiguohua
 * @date 2020/3/10 15:00
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final OrderInfoService orderInfoService;
    private final ClubCommentsService clubCommentsService;

    @Autowired
    public UserController(OrderInfoService orderInfoService, ClubCommentsService clubCommentsService) {
        this.orderInfoService = orderInfoService;
        this.clubCommentsService = clubCommentsService;
    }



    @GetMapping("/order")
    public ModelAndView order(@RequestParam(value = "uid") Integer uid,
                              @RequestParam(value = "pid") Integer pid,
                              Map<String,Object> map){
        Integer status = orderInfoService.createOrder(uid, pid);
        if(status == 1 ){
            //success
        }
        return new ModelAndView("user/xian",map);
    }


    @PostMapping("/insert")
    public ModelAndView addComment(@Valid ClubCommentForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map) {


        ClubCommentsDO clubCommentsDO = new ClubCommentsDO();
        try {
            BeanUtils.copyProperties(form, clubCommentsDO);
            clubCommentsService.add(clubCommentsDO);
        } catch (SoftException e) {
        }

        map.put("url", "/soft/clubProduct/list");
        return new ModelAndView("admin/common/success", map);
    }

}
