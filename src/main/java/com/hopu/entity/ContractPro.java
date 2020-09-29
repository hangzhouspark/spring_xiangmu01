package com.hopu.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * (SysCodeB)实体类
 *
 * @author makejava
 * @since 2020-09-25 09:15:19
 */
@Data
public class ContractPro {

    private String contract_Product_Id;

    private ContractC contractC;

    private String contract_Id;

    private Factory_c factory_c;

    private String factory_Id;

    private String product_Name;

    private String product_No;

    private String product_Image;

    private String product_Desc;

    private String loading_Rate;

    private String packing_Unit;

    private BigDecimal cnumber;

    private BigDecimal out_Number;

    private byte[] finished;

    private BigDecimal gross_Weight;

    private BigDecimal net_Weight;

    private BigDecimal size_Lenght;

    private BigDecimal size_Width;

    private BigDecimal size_Height;

    private String product_Request;

    private String factory;

    private BigDecimal price;

    private BigDecimal amount;

    private String cunit;

    private BigDecimal box_Num;

    private BigDecimal ex_Price;

    private String ex_Unit;

    private BigDecimal no_Tax;

    private BigDecimal tax;

    private BigDecimal cost_Price;

    private BigDecimal cost_Tax;

    private byte[] accessories;

    private BigDecimal order_No;

    private Integer conuntConPro;

}