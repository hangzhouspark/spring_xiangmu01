package com.hopu.mapper;

import com.hopu.entity.ContractC;
import com.hopu.entity.ExportC;

import java.util.List;

public interface ExportCMapper {

    public List<ExportC> selectExpC();

    public List<ContractC> selectContractByExpC();




}
