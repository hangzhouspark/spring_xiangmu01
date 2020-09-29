package com.hopu.controller;

import com.hopu.entity.Factory_c;
import com.hopu.service.Factory_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class Factory_ccontroller {
    @Autowired
    Factory_cService factory_cService;

    /***
     * 查询厂家信息
     * @param request
     * @return
     */
    @RequestMapping("/findoryAlll.action")
    public String findoryAlll(HttpServletRequest request) {
        List<Factory_c> list = factory_cService.findfactoryAll();
        request.getSession().setAttribute("dataList", list);
        return "basicinfo/factory/jFactoryList";

    }

    /***
     * 添加附件信息
     * @param entity
     * @return
     */
    @RequestMapping("/addoryy.action")
    public String addoryy(Factory_c entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setFactory_id(uuid);
        int i = factory_cService.addfactory_c(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "添加失败";

    }

    /***
     * 根据ID查询（回显信息）
     * @param factory_id
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/findorybyidd.action")
    public String findorybyidd(String factory_id, HttpServletRequest request, String id) {
        Factory_c factory_c = factory_cService.findbyfactory_id(factory_id);
        request.getSession().setAttribute("obj", factory_c);
        if (factory_c != null) {
            return "basicinfo/factory/jFactoryUpdate";
        }
        return "查询失败，跳转不了";

    }


    /***、
     * 启用状态功能
     * @param entity
     * @return
     */
    @RequestMapping("/updateoryy.action")
    public String updateoryy(Factory_c entity) {
        int i = factory_cService.updatefactory_c(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "修改失败";

    }

    /**
     * 停止状态
     *
     * @param entity
     * @return
     */
    @RequestMapping("/updateastat.action")
    public String updateastate(Factory_c entity) {
        int i = factory_cService.updateastate(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "失败";

    }

    /***
     * 批量删除
     * @param factory_id
     * @return
     */
    @RequestMapping("/delete.action")
    public String delete(String[] factory_id) {
        for (int i = 0; i < factory_id.length; i++) {
            factory_cService.deleteFactoryC(factory_id[i]);
        }
        return "redirect:findoryAlll.action";
    }


}
