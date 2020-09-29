package com.hopu.service;

import com.hopu.entity.ExtCproductC;

import java.util.List;

public interface ExtCproductCService {

    public List<ExtCproductC> selectExt(String contract_Product_Id);

    public int insertExt(ExtCproductC entity);

    public ExtCproductC selectExtByid(String ext_Cproduct_Id);

    public int updateExt(ExtCproductC entity);

    public int delExt(ExtCproductC entity);

    public int delExtByCon(String contract_Product_Id);
}
