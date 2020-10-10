package com.hopu.entity;

import lombok.Data;

import java.util.Date;

/**
 * (ExportProductC)实体类
 *
 * @author makejava
 * @since 2020-09-23 13:53:54
 */
@Data
public class ExportC {

    private String export_id;

    private Date input_Date;

    private String epnum;

    private String extnum;

    private String contract_Ids;

    private String customer_Contract;

    private String lcno;

    private String consignee;

    private String marks;

    private String remark;

    private String shipment_Port;

    private String destination_Port;

    private String transport_Mode;

    private String price_Condition;

    private Integer state;

    private Double gross_Weight;

    private Double net_Weight;

    private Double measurement;

    private String create_By;

    private String create_Dept;

    private Date create_Time;

}