package com.hopu.controller;

import com.hopu.entity.Factory_c;
import com.hopu.service.Factory_cService;
import com.hopu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class Factory_ccontroller {
    @Autowired
    Factory_cService factory_cService;

    @RequestMapping("/findoryAlll.action")
    public String findoryAlll(HttpServletRequest request) {
        List<Factory_c> list = factory_cService.findfactoryAll();
        request.getSession().setAttribute("dataList", list);
        return "basicinfo/factory/jFactoryList";

    }


    @RequestMapping("/addoryy.action")
    public String addoryy(Factory_c entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setFactory_id(uuid);
        System.out.println(entity);
        int i = factory_cService.addfactory_c(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "添加失败";

    }


    @RequestMapping("/findorybyidd.action")
    public String findorybyidd(String factory_id, HttpServletRequest request, String id) {
        System.out.println(factory_id);
        Factory_c factory_c = factory_cService.findbyfactory_id(factory_id);
        System.out.println(factory_c);
        request.getSession().setAttribute("obj", factory_c);
        if (factory_c != null) {
            return "basicinfo/factory/jFactoryUpdate";
        }
        return "查询失败，跳转不了";

    }


    @RequestMapping("/updateoryy.action")
    public String updateoryy(Factory_c entity) {
        int i = factory_cService.updatefactory_c(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "修改失败";

    }


    @RequestMapping("/updateastat.action")
    public String updateastate(Factory_c entity) {
        System.out.println(entity);
        int i = factory_cService.updateastate(entity);
        if (i > 0) {
            return "redirect:findoryAlll.action";
        }
        return "失败";

    }

    //批量删除
    @RequestMapping("/delete.action")
    public String delete(String[] factory_id) {
        for (int i = 0; i < factory_id.length; i++) {
            System.out.println(factory_id);
            factory_cService.deleteFactoryC(factory_id[i]);
        }
        return "redirect:findoryAlll.action";
    }


}
