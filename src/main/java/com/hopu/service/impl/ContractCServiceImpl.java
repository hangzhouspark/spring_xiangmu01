package com.hopu.service.impl;

import com.hopu.entity.ContractC;
import com.hopu.mapper.ContractCMapper;
import com.hopu.service.ContractCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractCServiceImpl implements ContractCService {

    @Autowired
    private ContractCMapper contractCMapper;

    @Override
    public List<ContractC> selectContract() {
        return contractCMapper.selectContract();
    }

    @Override
    public int insertContract(ContractC entity) {
        return contractCMapper.insertContract(entity);
    }

    @Override
    public ContractC selectByid(String contract_Id) {
        return contractCMapper.selectByid(contract_Id);
    }

    @Override
    public int updateCon(ContractC entity) {
        return contractCMapper.updateCon(entity);
    }

    @Override
    public int deleteCon(String contract_Id) {
        return contractCMapper.deleteCon(contract_Id);
    }

    @Override
    public int updatestate(ContractC entity) {
        return contractCMapper.updatestate(entity);
    }

}
