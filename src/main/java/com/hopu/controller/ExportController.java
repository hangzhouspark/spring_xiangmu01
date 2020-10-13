package com.hopu.controller;

import com.hopu.entity.*;
import com.hopu.service.*;
import com.hopu.util.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class ExportController {

    @Autowired
    private ExportCService exportCService;

    @Autowired
    private ContractCService contractCService;

    @Autowired
    private ContractProService contractProService;

    @Autowired
    private ExportProCService exportProCService;

    @Autowired
    private ExtCproductCService extCproductCService;

    @Autowired
    private ExtEproductCService extEproductCService;


    /***
     * 查询出口报运列表
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/findExpCAll.action")
    public String findExpCAll(HttpServletRequest request) {
        List<ExportC> exportCS = exportCService.selectExpC();
        System.out.println(exportCS.toString()+"*************************************");
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

    /**
     * 报运
     * @param userList
     * @return
     */
    @RequestMapping("/insertexport.action")
    public String insertexport(String  userList){
        String[] strs = userList.split(",");
        String contractNos = "";
        for (int i = 0; i < strs.length; i++) {
            ContractC selectcontbyid = contractCService.selectByid(strs[i]);
            contractNos += selectcontbyid.getContract_No() + " ";
        }
        contractNos = UtilFuns.delLastChar(contractNos);
        ExportC export = new ExportC();
        export.setExport_id(UUID.randomUUID().toString());
        export.setContract_Ids(UtilFuns.joinStr(strs, ","));
        export.setCustomer_Contract(contractNos);
        export.setState(0);
        exportCService.insertexport(export);

        for (int i = 0; i < strs.length; i++) {
            ContractC selectcontbyid = contractCService.selectByid(strs[i]);
            List<ContractPro> selecttwo = contractProService.selecttwo(selectcontbyid.getContract_Id());
            for (int j=0;j<selecttwo.size();j++){
                ExportProC ep=new ExportProC();
                ep.setEXPORT_PRODUCT_ID(UUID.randomUUID().toString());
                ep.setExport_Id(export.getExport_id());
                ep.setProduct_No(selecttwo.get(j).getProduct_No());
                ep.setPacking_Unit(selecttwo.get(j).getPacking_Unit());
                ep.setCnumber(selecttwo.get(j).getCnumber().intValue());
                ep.setBox_Num(selecttwo.get(j).getBox_Num().intValue());
                ep.setPrice(selecttwo.get(j).getPrice().doubleValue());
                exportProCService.insertexport(ep);
                List<ExtCproductC> selectthree = extCproductCService.selectthree(selecttwo.get(j).getContract_Product_Id());
                for (int k=0;k<selectthree.size();k++){
                    ExtEproductC extep=new ExtEproductC();
                    extep.setExt_eproduct_id(UUID.randomUUID().toString());
                    extep.setExport_product_id(ep.getEXPORT_PRODUCT_ID());
                    extep.setFactory_id(selectthree.get(k).getFactory_c().getFactory_id());
                    extEproductCService.insertexe(extep);
                }
            }
        }

        return "redirect:selectContractByExpC.action";

    }


}
