package com.hopu.entity;

import lombok.Data;

/**
 * (ExtCproductC)实体类
 *
 * @author makejava
 * @since 2020-09-25 09:15:12
 */
@Data
public class ExtCproductC {

    private String ext_Cproduct_Id;

    private ContractPro contract_product_c;

    private String contract_Product_Id;

    private Factory_c factory_c;

    private String factory_Id;

    private String factory_Name;

    private Integer ctype;

    private String product_No;

    private String product_Image;

    private String product_Desc;

    private Integer cnumber;

    private String packing_Unit;

    private double price;

    private double amount;

    private String product_Request;

    private Integer order_No;

}