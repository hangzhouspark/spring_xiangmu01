package com.hopu.controller;

import com.hopu.entity.ContractPro;
import com.hopu.entity.Export;
import com.hopu.entity.Factory_c;
import com.hopu.service.ContractProService;
import com.hopu.service.Factory_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractProController {

    @Autowired
    private ContractProService contractProService;

    @Autowired
    private Factory_cService factory_cService;


    @RequestMapping("/findConProAll.action")
    public String findConProAll(HttpServletRequest request) {
        List<ContractPro> list = contractProService.selectConProAll();
        request.getSession().setAttribute("ConProList", list);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        return "basicinfo/contractPro/ContractProList";
    }

    @RequestMapping("/addConPro.action")
    public String addConPro(ContractPro entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setContract_Product_Id(uuid);
        int i = contractProService.insertConPro(entity);
        if (i > 0) {
            return "redirect:findConProAll.action";
        }
        return "添加失败";
    }

    @RequestMapping("/DelConPro.action")
    public String DelConPro(String contract_Product_Id) {
        int i = contractProService.deleteConPro(contract_Product_Id);
        if (i > 0) {
            return "redirect:findConProAll.action";
        }
        return "删除失败";
    }

    @RequestMapping("/findConProAllByid.action")
    public String findConProAllByid(String contract_Product_Id,HttpServletRequest request) {
        ContractPro contractPro = contractProService.selectConProByid(contract_Product_Id);
        request.getSession().setAttribute("contractPro", contractPro);
        System.out.println("------------------------"+contractPro);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        System.out.println("======================="+factory_cs);
        return "basicinfo/contractPro/ContractProUpdate";
    }

    @RequestMapping("/UpdateConPro.action")
    public String UpdateConPro(ContractPro entity) {
        int i = contractProService.updateConPro(entity);
        if (i > 0) {
            return "redirect:findConProAll.action";
        }
        return "修改失败";
    }

}
