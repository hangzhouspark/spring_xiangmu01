package com.hopu.mapper;

import com.hopu.entity.ContractC;

import java.util.List;


public interface ContractCMapper {

    public List<ContractC> selectContract();

    public int insertContract(ContractC entity);

    public ContractC selectByid(String contract_Id);

    public int updateCon(ContractC entity);

    public int deleteCon(String contract_Id);

    public int updatestate(ContractC entity);


}
