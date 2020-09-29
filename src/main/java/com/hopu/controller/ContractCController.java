package com.hopu.controller;

import com.hopu.entity.ContractC;
import com.hopu.entity.ContractPro;
import com.hopu.service.ContractCService;
import com.hopu.service.ContractProService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractCController {

    @Autowired
    private ContractCService contractCService;

    @Autowired
    private ContractProService contractProService;

    /***
     * 时间类型处理
     * @param webDataBinder
     */
    @InitBinder
    public void init(WebDataBinder webDataBinder) {

        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

    }

    /***
     * 查询所有合同表
     * @param request
     * @return
     */
    @RequestMapping("/selectContract.action")
    public String updateastate(HttpServletRequest request) {
        List<ContractC> contractCS = contractCService.selectContract();
        request.getSession().setAttribute("ContractList", contractCS);
        return "basicinfo/contract/ContractList";
    }

    /***
     * 打印功能
     * @param response
     * @param contract_Id
     * @throws IOException
     */
    @RequestMapping("/Printing.action")
    public void Printing(HttpServletResponse response, String contract_Id) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("出货表");
        List<ContractPro> classmateList = contractProService.selectConProAll(contract_Id);
        String fileName = new Date() + ".xls";
        int rowNum = 1;
        String[] headers = {"客户", "订单号", "货号", "数量", "工厂", "工厂交期", "船期", "贸易条款"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for (ContractPro contractPro : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(contractPro.getContractC().getContract_No());
            row1.createCell(1).setCellValue(contractPro.getContract_Product_Id());
            row1.createCell(2).setCellValue(contractPro.getProduct_No());
            row1.createCell(3).setCellValue(contractPro.getCnumber().doubleValue());
            row1.createCell(4).setCellValue(contractPro.getFactory());
            row1.createCell(5).setCellValue(contractPro.getContractC().getDelivery_Period());
            row1.createCell(6).setCellValue(contractPro.getContractC().getShip_Time());
            row1.createCell(7).setCellValue(contractPro.getOut_Number().doubleValue());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }


    /***
     * 去添加界面
     * @return
     */
    @RequestMapping("/goConInsert.action")
    public String goConInsert() {

        return "basicinfo/contract/ContractCreate";
    }

    /***
     * 添加合同表
     * @param entity
     * @return
     */
    @RequestMapping("/ConInsert.action")
    public String ConInsert(ContractC entity) {
        String uuid = String.valueOf(UUID.randomUUID());
        entity.setContract_Id(uuid);
        entity.setState(0);
        int i = contractCService.insertContract(entity);
        if (i > 0) {
            return "redirect:selectContract.action";
        }
        return "basicinfo/contract/ContractCreate";
    }

    /***
     * 根据ID查询（修改回显）
     * @param contract_Id
     * @param request
     * @return
     */
    @RequestMapping("/selectByid.action")
    public String selectByid(String contract_Id, HttpServletRequest request) {
        ContractC contractC = contractCService.selectByid(contract_Id);
        request.getSession().setAttribute("obj", contractC);
        return "basicinfo/contract/ContractUpdate";
    }

    /***
     * 修改合同表
     * @param entity
     * @return
     */
    @RequestMapping("/updateCon.action")
    public String updateCon(ContractC entity) {
        int i = contractCService.updateCon(entity);
        if (i > 0) {
            return "redirect:selectContract.action";
        }
        return "basicinfo/contract/ContractCreate";
    }


    /***
     * 删除合同表
     * @param contract_Id
     * @return
     */
    @RequestMapping("/deleteCon.action")
    public String deleteCon(String[] contract_Id) {
        for (int i = 0; i < contract_Id.length; i++) {
            contractCService.deleteCon(contract_Id[i]);
        }
        return "redirect:selectContract.action";
    }

    /***
     * 上报功能
     * @param contract_Id
     * @return
     */
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

    /***
     * 取消功能
     * @param contract_Id
     * @return
     */
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
