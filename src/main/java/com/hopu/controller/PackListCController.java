package com.hopu.controller;

import com.hopu.entity.ExportC;
import com.hopu.entity.PackListC;
import com.hopu.service.ExportCService;
import com.hopu.service.PackListCService;
import com.hopu.util.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PackListCController {

    @Autowired
    private PackListCService packListCService;

    @Autowired
    private ExportCService exportCService;

    /***
     * 查询装箱
     * @return
     */
    @RequestMapping("/selectPacklist.action")
    public String selectPacklist(HttpServletRequest request) {
        List<PackListC> packListCS = packListCService.selectPacklist();
        request.getSession().setAttribute("dataList", packListCS);
        return "basicinfo/packinglist/jPackingListList";
    }

    /**
     * goinsert
     *
     * @param export_id
     * @param model
     * @return
     */
    @RequestMapping("/goPacklistinsert.action")
    public String goPacklistinsert(String export_id, Model model, HttpServletRequest request) {
        String[] strs = export_id.split(",");
        request.getSession().setAttribute("strs", strs);
        if (strs == null) {
            return "请选择一项";
        } else {
            StringBuffer sBuf = new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                ExportC exportC = exportCService.selectExpCByid(strs[i]);
                sBuf.append("<input type='checkbox' name='exportIds' checked='checked' value='").append(strs[i]).append("|").append(exportC.getCustomer_Contract()).append("' class='input'/>");
                sBuf.append(exportC.getCustomer_Contract()).append("&nbsp;&nbsp;");
                model.addAttribute("divData", sBuf.toString());
            }
            return "basicinfo/packinglist/jPackingListCreate";
        }
    }

    @RequestMapping("/Packlistinsert.action")
    public String Packlistinsert(PackListC entity, HttpServletRequest request) {
        String[] strs = (String[]) request.getSession().getAttribute("strs");
        entity.setPacking_list_id(UUID.randomUUID().toString());
        entity.setExport_id(UtilFuns.joinStr(strs, ","));
        entity.setState("0");
        int i = packListCService.insertPack(entity);
        if (i > 0) {
            return "redirect:selectPacklist.action";
        } else {
            return "失败";
        }

    }

    @RequestMapping("/goPacklistupdate.action")
    public String goPacklistupdate(String packing_list_id,HttpServletRequest request,Model model) {
        PackListC packListC = packListCService.selectPackByid(packing_list_id);
        request.getSession().setAttribute("obj", packListC);
        String export_id = packListC.getExport_id();
        String[] strs = export_id.split(",");
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            ExportC exportC = exportCService.selectExpCByid(strs[i]);
            sBuf.append("<input type='checkbox' name='exportIds' checked='checked' value='").append(strs[i]).append("|").append(exportC.getCustomer_Contract()).append("' class='input'/>");
            sBuf.append(exportC.getCustomer_Contract()).append("&nbsp;&nbsp;");
            model.addAttribute("divData", sBuf.toString());
        }
        return "basicinfo/packinglist/jPackingListUpdate";
    }


    @RequestMapping("/Packlistupdate.action")
    public String Packlistupdate(PackListC entity) {
        int i = packListCService.updatePack(entity);
        if (i > 0) {
            return "redirect:selectPacklist.action";
        } else {
            return "失败";
        }
    }

    @RequestMapping("/LookPacklist.action")
    public String LookPacklist(String packing_list_id,HttpServletRequest request,Model model) {
        PackListC packListC = packListCService.selectPackByid(packing_list_id);
        request.getSession().setAttribute("obj", packListC);
        String export_id = packListC.getExport_id();
        String[] strs = export_id.split(",");
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            ExportC exportC = exportCService.selectExpCByid(strs[i]);
            sBuf.append(exportC.getCustomer_Contract()).append("&nbsp;&nbsp;");
            model.addAttribute("divData", sBuf.toString());
        }
        return "basicinfo/packinglist/jPackingListView";
    }
}
