package com.net.soft.controller.admin;

import com.github.pagehelper.PageInfo;
import com.net.soft.converter.OrderInfoDOtoOrderDTOConverter;
import com.net.soft.exception.SoftException;
import com.net.soft.model.OrderInfoDO;
import com.net.soft.model.dto.OrderDTO;
import com.net.soft.service.OrderInfoService;
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
 * @date 2020/3/8 17:49
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {

    private final OrderInfoService orderInfoService;

    @Autowired
    public OrderInfoController(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "uid",required = false) Integer uid,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        List<OrderInfoDO> orderInfoList;
        if(uid == null || uid == 0){
            orderInfoList = orderInfoService.findAll(page,size);
            uid = 0;
        }else {
            orderInfoList = orderInfoService.findByUid(uid,page,size);
        }
        if(orderInfoList == null || orderInfoList.size() == 0){
            return new ModelAndView("admin/order/null");
        }

        List<OrderDTO> orderDTOList = OrderInfoDOtoOrderDTOConverter.convert(orderInfoList);

        PageInfo pageList = new PageInfo(orderDTOList);
        map.put("orderInfoList",pageList);
        map.put("uid",uid);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/order/list",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "uid", required = false) Integer uid,
                               Map<String, Object> map) {
        try {
            if (id != null) {
                Integer status = orderInfoService.findStatus(id);
                if(status == 0){
                    orderInfoService.finishOrder(id);
                }else{
                    map.put("msg", "订单状态不允许此操作！ ");
                    map.put("url", "/soft/orderInfo/list?uid="+uid);
                    return new ModelAndView("admin/common/error", map);
                }
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/orderInfo/list?uid="+uid);
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/orderInfo/list?uid="+uid);
        return new ModelAndView("admin/common/success", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "uid", required = false) Integer uid,
                               Map<String, Object> map) {
        try {
            if (id != null) {
                Integer status = orderInfoService.findStatus(id);
                if(status == 0){
                    orderInfoService.cancelOrder(id);
                }else{
                    map.put("msg", "订单状态不允许此操作！ ");
                    map.put("url", "/soft/orderInfo/list?uid="+uid);
                    return new ModelAndView("admin/common/error", map);
                }
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/orderInfo/list?uid="+uid);
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/orderInfo/list?uid="+uid);
        return new ModelAndView("admin/common/success", map);
    }
}
