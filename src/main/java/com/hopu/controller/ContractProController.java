package com.hopu.controller;

import com.hopu.entity.ContractPro;
import com.hopu.entity.ExtCproductC;
import com.hopu.entity.Factory_c;
import com.hopu.service.ContractProService;
import com.hopu.service.ExtCproductCService;
import com.hopu.service.Factory_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jnlp.ExtendedService;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractProController {

    @Autowired
    private ContractProService contractProService;

    @Autowired
    private Factory_cService factory_cService;

    @Autowired
    private ExtCproductCService extCproductCService;

    /***
     * 查询所有货物
     * @param contract_Id
     * @param request
     * @return
     */
    @RequestMapping("/findConProAll.action")
    public String findConProAll(String contract_Id, HttpServletRequest request) {
        List<ContractPro> list = contractProService.selectConProAll(contract_Id);
        request.getSession().setAttribute("ConProList", list);
        request.getSession().setAttribute("contractId", contract_Id);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        return "basicinfo/contractPro/ContractProList";
    }

    /***
     * 添加货物
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("/addConPro.action")
    public String addConPro(ContractPro entity, HttpServletRequest request) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setContract_Product_Id(uuid);
        BigDecimal cnumber = entity.getCnumber();
        BigDecimal price = entity.getPrice();
        BigDecimal result3 = cnumber.multiply(price);
        entity.setAmount(result3);
        String contract_ids = (String) request.getSession().getAttribute("contractId");
        entity.setContract_Id(contract_ids);
        int i = contractProService.insertConPro(entity);
        if (i > 0) {
            return "redirect:findConProAll.action?contract_Id=" + contract_ids + "";
        }
        return "添加失败";
    }

    /***
     * 删除货物（级联删除【附加表】）
     * @param contract_Product_Id
     * @param request
     * @return
     */
    @RequestMapping("/DelConPro.action")
    public String DelConPro(String contract_Product_Id, HttpServletRequest request) {
        String contract_ids = (String) request.getSession().getAttribute("contractId");
        List<ExtCproductC> extCproductCS = extCproductCService.selectExt(contract_Product_Id);
        if (extCproductCS.size() != 0) {
            int i1 = extCproductCService.delExtByCon(contract_Product_Id);
            if (i1 > 0) {
                int i = contractProService.deleteConPro(contract_Product_Id);
                if (i > 0) {
                    return "redirect:findConProAll.action?contract_Id=" + contract_ids + "";
                }
                return "删除失败";
            }
            return "删除失败";

        } else {
            int i = contractProService.deleteConPro(contract_Product_Id);
            if (i > 0) {
                return "redirect:findConProAll.action?contract_Id=" + contract_ids + "";
            }
            return "删除失败";
        }


    }

    /**
     * 根据ID查询（修改回显）
     * @param contract_Product_Id
     * @param request
     * @return
     */
    @RequestMapping("/findConProAllByid.action")
    public String findConProAllByid(String contract_Product_Id, HttpServletRequest request) {
        ContractPro contractPro = contractProService.selectConProByid(contract_Product_Id);
        request.getSession().setAttribute("contractPro", contractPro);
        List<Factory_c> factory_cs = factory_cService.findfactoryAll();
        request.getSession().setAttribute("factory_cs", factory_cs);
        return "basicinfo/contractPro/ContractProUpdate";
    }

    /***
     * 修改货物表信息
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("/UpdateConPro.action")
    public String UpdateConPro(ContractPro entity, HttpServletRequest request) {
        String contract_ids = (String) request.getSession().getAttribute("contractId");
        int i = contractProService.updateConPro(entity);
        if (i > 0) {
            return "redirect:findConProAll.action?contract_Id=" + contract_ids + "";
        }
        return "修改失败";
    }

}
