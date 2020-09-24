package com.hopu.mapper;

import com.hopu.entity.ContractPro;

import java.util.List;

public interface ContractProMapper {

    public List<ContractPro> selectConProAll();

    public int insertConPro(ContractPro entity);

    public int deleteConPro(String contract_Product_Id);

    public ContractPro selectConProByid(String contract_Product_Id);

    public int updateConPro(ContractPro entity);
}
