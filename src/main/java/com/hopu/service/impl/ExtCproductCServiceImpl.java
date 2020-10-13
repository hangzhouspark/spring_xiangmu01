package com.hopu.service.impl;

import com.hopu.entity.ExtCproductC;
import com.hopu.mapper.ExtCproductCMapper;
import com.hopu.service.ExtCproductCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtCproductCServiceImpl implements ExtCproductCService {

    @Autowired
    private ExtCproductCMapper extCproductCMapper;


    @Override
    public List<ExtCproductC> selectExt(String contract_Product_Id) {
        return extCproductCMapper.selectExt(contract_Product_Id);
    }

    @Override
    public int insertExt(ExtCproductC entity) {
        return extCproductCMapper.insertExt(entity);
    }

    @Override
    public ExtCproductC selectExtByid(String ext_Cproduct_Id) {
        return extCproductCMapper.selectExtByid(ext_Cproduct_Id);
    }

    @Override
    public int updateExt(ExtCproductC entity) {
        return extCproductCMapper.updateExt(entity);
    }

    @Override
    public int delExt(ExtCproductC entity) {
        return extCproductCMapper.delExt(entity);
    }

    @Override
    public int delExtByCon(String contract_Product_Id) {
        return extCproductCMapper.delExtByCon(contract_Product_Id);
    }

    @Override
    public List<ExtCproductC> selectthree(String contract_product_c) {
        return extCproductCMapper.selectthree(contract_product_c);
    }
}
