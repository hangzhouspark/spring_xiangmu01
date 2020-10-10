package com.hopu.controller;

import com.hopu.entity.*;
import com.hopu.service.ExtCproductCService;
import com.hopu.service.Factory_cService;
import com.hopu.service.SysCodeBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author 26417
 */
@Controller
public class ExtCproductCController {

    @Autowired
    private ExtCproductCService extCproductCService;

    @Autowired
    private Factory_cService factory_cService;

    @Autowired
    private SysCodeBService sysCodeBService;

    /**
     * 查询所有附件
     * @param contract_Product_Id
     * @param request
     * @return
     */
    @RequestMapping("/selectExt.action")
    public String selectExt(String contract_Product_Id, HttpServletRequest request) {
        List<ExtCproductC> extCproductCS = extCproductCService.selectExt(contract_Product_Id);
        request.getSession().setAttribute("extCproductCS", extCproductCS);
        request.getSession().setAttribute("contract_Product_Id", contract_Product_Id);
        String contract_ids = (String) request.getSession().getAttribute("contractId");
        request.getSession().setAttribute("contract_ids", contract_ids);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        List<SysCodeB> sysCodeBS = sysCodeBService.selectSys();
        request.getSession().setAttribute("sysCodeBS", sysCodeBS);
        return "basicinfo/jExtCproduct/jExtCproductCreate";
    }

    /***
     * 添加附件表
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("/insertExt.action")
    public String insertExt(ExtCproductC entity, HttpServletRequest request) {
        String uuid = String.valueOf(UUID.randomUUID());
        String contract_product_ids = (String) request.getSession().getAttribute("contract_Product_Id");
        entity.setContract_Product_Id(contract_product_ids);
        entity.setExt_Cproduct_Id(uuid);
        entity.setAmount(entity.getCnumber() * entity.getPrice());
        Factory_c factory_cs = factory_cService.findbyfactory_id(entity.getFactory_Id());
        entity.setFactory_Name(factory_cs.getFull_name());
        int i = extCproductCService.insertExt(entity);
        if (i > 0) {
            return "redirect:selectExt.action?contract_Product_Id=" + contract_product_ids + "";
        }
        return "添加失败";
    }

    /***
     * 删除附件表
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("/delExt.action")
    public String delExt(ExtCproductC entity, HttpServletRequest request) {
        String contract_product_ids = (String) request.getSession().getAttribute("contract_Product_Id");
        int i = extCproductCService.delExt(entity);
        if (i > 0) {

            return "redirect:selectExt.action?contract_Product_Id=" + contract_product_ids + "";
        }
        return "删除失败";
    }

    /***
     * 根据ID查询（回显）
     * @param ext_Cproduct_Id
     * @param request
     * @return
     */
    @RequestMapping("/selectExtByid.action")
    public String selectExtByid(String ext_Cproduct_Id, HttpServletRequest request) {
        ExtCproductC extCproductC = extCproductCService.selectExtByid(ext_Cproduct_Id);
        request.getSession().setAttribute("obj", extCproductC);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        List<SysCodeB> sysCodeBS = sysCodeBService.selectSys();
        request.getSession().setAttribute("sysCodeBS", sysCodeBS);
        String contract_product_ids = (String) request.getSession().getAttribute("contract_Product_Id");
        request.getSession().setAttribute("contract_product_ids", contract_product_ids);
        return "basicinfo/jExtCproduct/jExtCproductUpdate";
    }

    /***
     * 修改附件表
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("/updateExt.action")
    public String updateExt(ExtCproductC entity, HttpServletRequest request) {
        String contract_product_ids = (String) request.getSession().getAttribute("contract_Product_Id");
        Factory_c factory_cs = factory_cService.findbyfactory_id(entity.getFactory_Id());
        entity.setContract_Product_Id(contract_product_ids);
        entity.setAmount(entity.getCnumber() * entity.getPrice());
        entity.setFactory_Name(factory_cs.getFull_name());
        int i = extCproductCService.updateExt(entity);
        if (i > 0) {
            return "redirect:selectExt.action?contract_Product_Id=" + contract_product_ids + "";
        }
        return "修改失败";
    }


}
