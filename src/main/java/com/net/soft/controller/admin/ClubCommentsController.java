package com.net.soft.controller.admin;

import com.github.pagehelper.PageInfo;
import com.net.soft.exception.SoftException;
import com.net.soft.model.ClubCommentsDO;
import com.net.soft.service.ClubCommentsService;
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
@RequestMapping("/clubComments")
public class ClubCommentsController {

    private final ClubCommentsService clubCommentsService;

    @Autowired
    public ClubCommentsController(ClubCommentsService clubCommentsService) {
        this.clubCommentsService = clubCommentsService;
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "cid") Integer cid,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        List<ClubCommentsDO> commentsList = clubCommentsService.findByCid(cid,page,size);
        if(commentsList == null || commentsList.size() == 0){
            return new ModelAndView("admin/comments/null");
        }
        PageInfo pageList = new PageInfo(commentsList);
        map.put("commentsList",pageList);
        map.put("cid",cid);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/comments/list",map);
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "cid",required = false) Integer cid,
                               Map<String, Object> map) {
        try {
            if (id != null && cid != null) {
                clubCommentsService.delete(id);
            }
        } catch (SoftException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/clubComments/list?cid="+cid);
            return new ModelAndView("admin/common/error", map);
        }
        map.put("url", "/soft/clubComments/list?cid="+cid);
        return new ModelAndView("admin/common/success", map);
    }
}
