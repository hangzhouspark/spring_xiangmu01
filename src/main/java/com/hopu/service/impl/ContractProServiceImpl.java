package com.hopu.service.impl;

import com.hopu.entity.ContractPro;
import com.hopu.mapper.ContractProMapper;
import com.hopu.service.ContractProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractProServiceImpl implements ContractProService {

    @Autowired
    private ContractProMapper contractProMapper;


    @Override
    public List<ContractPro> selectConProAll(String contract_Id) {
        return contractProMapper.selectConProAll(contract_Id);
    }

    @Override
    public int insertConPro(ContractPro entity) {
        return contractProMapper.insertConPro(entity);
    }

    @Override
    public int deleteConPro(String contract_Product_Id) {
        return contractProMapper.deleteConPro(contract_Product_Id);
    }

    @Override
    public ContractPro selectConProByid(String contract_Product_Id) {
        return contractProMapper.selectConProByid(contract_Product_Id);
    }

    @Override
    public int updateConPro(ContractPro entity) {
        return contractProMapper.updateConPro(entity);
    }

    @Override
    public List<ContractPro> selectAllConPro() {
        return contractProMapper.selectAllConPro();
    }

    @Override
    public ContractPro selectCount(String contract_Id) {
        return contractProMapper.selectCount(contract_Id);
    }

    @Override
    public List<ContractPro> poiCh(String inputDate) {
        return contractProMapper.poiCh(inputDate);
    }
}
