package com.hopu.controller;

import com.hopu.entity.ContractC;
import com.hopu.entity.ExportC;
import com.hopu.service.ExportCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private ExportCService exportCService;

    /***
     * 查询出口报运列表
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/findExpCAll.action")
    public String findExpCAll(HttpServletRequest request) {
        List<ExportC> exportCS = exportCService.selectExpC();
        request.getSession().setAttribute("dataList", exportCS);
        return "basicinfo/exportC/jExportList";
    }


    /***
     * 购销合同查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/selectContractByExpC.action")
    public String selectContractByExpC(HttpServletRequest request) {
        List<ContractC> contractCS = exportCService.selectContractByExpC();
        request.getSession().setAttribute("contractList", contractCS);
        return "basicinfo/exportC/jContractList";
    }


}
