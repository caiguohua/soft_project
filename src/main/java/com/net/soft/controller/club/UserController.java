package com.net.soft.controller.club;

import com.github.pagehelper.PageInfo;
import com.net.soft.converter.ClubProductDOtoProductDTOConverter;
import com.net.soft.exception.SoftException;
import com.net.soft.form.ClubCommentForm;
import com.net.soft.model.ClubCommentsDO;
import com.net.soft.model.ClubInfoDO;
import com.net.soft.model.ClubProductDO;
import com.net.soft.model.dto.ProductDTO;
import com.net.soft.service.ClubCommentsService;
import com.net.soft.service.ClubInfoService;
import com.net.soft.service.ClubProductService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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
    private final ClubProductService clubProductService;
    private final ClubInfoService clubInfoService;

    @Autowired
    public UserController(OrderInfoService orderInfoService, ClubCommentsService clubCommentsService, ClubProductService clubProductService, ClubInfoService clubInfoService) {
        this.orderInfoService = orderInfoService;
        this.clubCommentsService = clubCommentsService;
        this.clubProductService = clubProductService;
        this.clubInfoService = clubInfoService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "lid", defaultValue = "0",required = false) Integer lid,
                             @RequestParam(value = "uid") Integer uid,
                             @RequestParam(value = "page", defaultValue = "1",required = false) Integer page,
                             @RequestParam(value = "size", defaultValue = "3",required = false) Integer size,
                             Map<String,Object> map) {
        List<ClubInfoDO> clubInfoList;
        if(lid == 0){
            clubInfoList = clubInfoService.findAll(page,size);
        }else {
            clubInfoList = clubInfoService.getClubInfoByLabel(lid,page,size);
        }
        if(clubInfoList == null || clubInfoList.size() == 0){
            return new ModelAndView("user/nullClub");
        }
        PageInfo pageList = new PageInfo(clubInfoList);
        map.put("clubInfoList",pageList);
        map.put("uid",uid);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("user/club",map);
    }

    @GetMapping(value = "/getInfo")
    public ModelAndView getInfo(@RequestParam(value = "cid") Integer cid,
                                @RequestParam(value = "uid") Integer uid,
                                @RequestParam(value = "page", defaultValue = "1",required = false) Integer page,
                                @RequestParam(value = "size", defaultValue = "5",required = false) Integer size,
                                Map<String,Object> map){
        ClubInfoDO clubInfoDO = clubInfoService.findOne(cid);
        map.put("clubInfo",clubInfoDO);
        map.put("uid",uid);
        List<ClubCommentsDO> clubCommentList = clubCommentsService.findByCid(cid,1,10);
        if(clubCommentList == null || clubCommentList.size() == 0){
            ClubCommentsDO clubCommentsDO = new ClubCommentsDO();
            clubCommentsDO.setComment("没有评论哦，快来评论吧ớ ₃ờ\n");
            List<ClubCommentsDO> noComment = new ArrayList<>();
            noComment.add(clubCommentsDO);
            map.put("commentList",noComment);
        }else{
            map.put("commentList",clubCommentList);
        }
        List<ClubProductDO> list = clubProductService.findByCid(cid,page,size);
        if(list == null || list.size() == 0){
            return new ModelAndView("user/nullClubInfo");
        }
        List<ProductDTO> productDTOList = ClubProductDOtoProductDTOConverter.convert(list);
        PageInfo pageList = new PageInfo(productDTOList);
        map.put("clubProductList",pageList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("user/clubInfo",map);
    }

    @GetMapping("/order")
    public ModelAndView order(@RequestParam(value = "uid") Integer uid,
                              @RequestParam(value = "pid") Integer pid,
                              @RequestParam(value = "cid") Integer cid,
                              Map<String,Object> map){
        Boolean status = orderInfoService.createOrder(uid, pid);
        if(status == true ){
            map.put("uid",uid);
            map.put("url", "/soft/user/getInfo?cid="+cid+"&uid="+uid);
            logger.info("下单成功！");
            return new ModelAndView("admin/common/success", map);
        }
        map.put("msg", "预约失败");
        map.put("url", "/soft/user/getInfo?cid="+cid+"&uid="+uid);
        return new ModelAndView("admin/common/error", map);
    }


    @PostMapping("/comment")
    public ModelAndView addComment(@Valid ClubCommentForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map) {


        ClubCommentsDO clubCommentsDO = new ClubCommentsDO();
        try {
            BeanUtils.copyProperties(form, clubCommentsDO);
            clubCommentsService.add(clubCommentsDO);
        } catch (SoftException e) {
            map.put("msg", "评论失败");
            map.put("url", "/soft/user/getInfo?cid="+form.getCid()+"&uid="+form.getUid());
            return new ModelAndView("admin/common/error", map);
        }

        map.put("url", "/soft/user/getInfo?cid="+form.getCid()+"&uid="+form.getUid());
        return new ModelAndView("admin/common/success", map);
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        request.getSession().removeAttribute("username");
        request.getSession().invalidate();

        map.put("msg", "登出成功");
        map.put("url", "/soft/club/index");
        return new ModelAndView("admin/common/success", map);
    }

}
