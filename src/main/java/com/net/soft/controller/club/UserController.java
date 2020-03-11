package com.net.soft.controller.club;

import com.github.pagehelper.PageInfo;
import com.net.soft.converter.ClubProductDOtoProductDTOConverter;
import com.net.soft.exception.SoftException;
import com.net.soft.from.ClubCommentForm;
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

import javax.validation.Valid;
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
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("user/club",map);
    }

    @GetMapping(value = "/getInfo")
    public ModelAndView getInfo(Map<String,Object> map){
        List<ClubProductDO> list = clubProductService.findByCid(1,1,10);
        List<ProductDTO> productDTOList = ClubProductDOtoProductDTOConverter.convert(list);
        PageInfo pageList = new PageInfo(productDTOList);
        map.put("clubProductList",pageList);
        map.put("currentPage", 1);
        map.put("size", 10);
        return new ModelAndView("user/xian",map);
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


//    @GetMapping(value="/getInfo")
//    public void query(HttpServletResponse resp) {
//        try {
//             /*list集合中存放的是好多student对象*/
//            List<ClubProductDO> list = clubProductService.findAll(1,10);
//            /*将list集合装换成json对象*/
//                    JSONArray data = JSONArray.fromObject(list);
//                   //接下来发送数据
//                       /*设置编码，防止出现乱码问题*/
//                         resp.setCharacterEncoding("utf-8");
//                         /*得到输出流*/
//                         PrintWriter respWritter = resp.getWriter();
//                         /*将JSON格式的对象toString()后发送*/
//                         respWritter.append(data.toString());
//                     } catch (Exception e) {
//                         e.printStackTrace();
//                     }
//    }

}
