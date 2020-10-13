package com.hopu.entity;

import lombok.Data;

@Data
public class ExtEproductC {

    public String ext_eproduct_id;

    public Factory_c factory_c;

    public String factory_id;

    public ExportProC exportProC;

    public String export_product_id;

    public String contract_product_id;

    public Integer ctype;

    public String product_name;

    public String product_no;

    public String product_image;

    public String product_desc;

    public String loading_rate;

    public String packing_unit;

    public Integer cnumber;

    public Integer out_number;

    public Integer finished;

    public Double gross_weight;

    public Double net_weight;

    public Double size_lenght;

    public Double size_width;

    public Double size_height;

    public String product_request;

    public String factory;

    public Double price;

    public Double amount;

    public String cunit;

    public Integer box_num;

    public Double ex_price;

    public String ex_unit;

    public Double no_tax;

    public Double tax;

    public Double cost_price;

    public Double cost_tax;

    public Integer accessories;

    public Integer order_no;
}
