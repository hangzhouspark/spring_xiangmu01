package com.hopu.controller;

import com.hopu.entity.ContractC;
import com.hopu.entity.Factory_c;
import com.hopu.service.ContractCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractCController {

    @Autowired
    private ContractCService contractCService;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {

        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

    }

    @RequestMapping("/selectContract.action")
    public String updateastate(Factory_c entity, HttpServletRequest request) {
        List<ContractC> contractCS = contractCService.selectContract();
        request.getSession().setAttribute("ContractList", contractCS);
        return "basicinfo/contract/ContractList";
    }

    @RequestMapping("/goConInsert.action")
    public String goConInsert() {

        return "basicinfo/contract/ContractCreate";
    }

    @RequestMapping("/ConInsert.action")
    public String ConInsert(ContractC entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setContract_Id(uuid);
        entity.setState(0);
        System.out.println("-------------------------------" + entity);
        int i = contractCService.insertContract(entity);
        if (i > 0) {
            return "redirect:selectContract.action";
        }
        return "basicinfo/contract/ContractCreate";
    }

    @RequestMapping("/selectByid.action")
    public String selectByid(String contract_Id, HttpServletRequest request) {
        ContractC contractC = contractCService.selectByid(contract_Id);
        request.getSession().setAttribute("obj", contractC);
        return "basicinfo/contract/ContractUpdate";
    }

    @RequestMapping("/updateCon.action")
    public String updateCon(ContractC entity) {
        System.out.println("-------------------------------" + entity);
        int i = contractCService.updateCon(entity);
        if (i > 0) {
            return "redirect:selectContract.action";
        }
        return "basicinfo/contract/ContractCreate";
    }


    @RequestMapping("/deleteCon.action")
    public String deleteCon(String[] contract_Id) {
        for (int i = 0; i < contract_Id.length; i++) {
            System.out.println(contract_Id + "---------");
            contractCService.deleteCon(contract_Id[i]);
        }
        return "redirect:selectContract.action";
    }


    @RequestMapping("/uploadAndremoveContract.action")
    public String uploadAndremoveContract(String[] contract_Id) {
        int j = 0;
        for (String s : contract_Id) {
            ContractC contractC1 = contractCService.selectByid(s);
            j++;
            if (contractC1.getState() == 1) {
                contractC1.setState(0);
                int i = contractCService.updatestate(contractC1);
                if (j == s.length()) {
                    if (i > 0) {
                        return "redirect:selectContract.action";
                    } else {
                        return "error";
                    }
                }

            }
        }
        return "redirect:selectContract.action";
    }

    @RequestMapping("/uploadAndremoveContractTwo.action")
    public String uploadAndremoveContractTwo(String[] contract_Id) {
        int j = 0;
        for (String s : contract_Id) {
            ContractC contractC1 = contractCService.selectByid(s);
            j++;
            if (contractC1.getState() == 0) {
                contractC1.setState(1);
                int i = contractCService.updatestate(contractC1);
                if (j == s.length()) {
                    if (i > 0) {
                        return "redirect:selectContract.action";
                    } else {
                        return "error";
                    }
                }

            }
        }
        return "redirect:selectContract.action";
    }


}
