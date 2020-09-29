package com.hopu.controller;

import com.hopu.entity.Export;
import com.hopu.entity.Factory_c;
import com.hopu.service.ExportService;
import com.hopu.service.Factory_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class ExportController {

    @Autowired
    private ExportService exportService;

    @Autowired
    private Factory_cService factory_cService;

    @RequestMapping("/findExpAll.action")
    public String findoryAlll(HttpServletRequest request) {
        List<Export> list = exportService.selectExp();
        request.getSession().setAttribute("ExportList", list);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        return "basicinfo/export/ExportList";
    }

    @RequestMapping("/addExp.action")
    public String addoryy(Export entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setEXPORTPRODUCTID(uuid);
        int i = exportService.insertExp(entity);
        if (i > 0) {
            return "redirect:findExpAll.action";
        }
        return "添加失败";
    }

    @RequestMapping("/delExp.action")
    public String delExp(String EXPORTPRODUCTID) {
        int i = exportService.delExp(EXPORTPRODUCTID);
        if (i > 0) {
            return "redirect:findExpAll.action";
        }
        return "删除失败";
    }

    @RequestMapping("/findExpByid.action")
    public String findoryAlll(String EXPORTPRODUCTID,HttpServletRequest request) {
        Export export = exportService.selectByidExp(EXPORTPRODUCTID);
        request.getSession().setAttribute("export", export);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        return "basicinfo/export/ExportUpdate";
    }

    @RequestMapping("/updateExp.action")
    public String updateExp(Export entity) {
        int i = exportService.updateExp(entity);
        if (i > 0) {
            return "redirect:findExpAll.action";
        }
        return "删除失败";
    }
}
