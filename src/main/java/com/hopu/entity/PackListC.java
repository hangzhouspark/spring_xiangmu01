package com.hopu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PackListC {

    private String packing_list_id;

    private ExportC exportC;

    private String export_id;

    private String seller;

    private String buyer;

    private String invoice_no;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoice_date;

    private String marks;

    private String descriptions;

    private String create_by;

    private String create_dept;

    private Date create_time;

    private String exportIds;

    private String exportNos;

    private String state;

}
