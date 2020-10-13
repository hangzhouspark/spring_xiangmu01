package com.hopu.service;

import com.hopu.entity.ContractC;
import com.hopu.entity.ExportC;

import java.util.List;

public interface ExportCService {

    public List<ExportC> selectExpC();

    public List<ContractC> selectContractByExpC();

    public int insertexport(ExportC entity);

    public ExportC selectExpCByid(String export_id);


}
