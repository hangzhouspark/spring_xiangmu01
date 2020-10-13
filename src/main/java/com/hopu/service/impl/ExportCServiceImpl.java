package com.hopu.service.impl;

import com.hopu.entity.ContractC;
import com.hopu.entity.ExportC;
import com.hopu.mapper.ExportCMapper;
import com.hopu.service.ExportCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportCServiceImpl implements ExportCService {

    @Autowired
    private ExportCMapper exportCMapper;

    @Override
    public List<ExportC> selectExpC() {
        return exportCMapper.selectExpC();
    }

    @Override
    public List<ContractC> selectContractByExpC() {
        return exportCMapper.selectContractByExpC();
    }

    @Override
    public int insertexport(ExportC entity) {
        return exportCMapper.insertexport(entity);
    }

    @Override
    public ExportC selectExpCByid(String export_id) {
        return exportCMapper.selectExpCByid(export_id);
    }


}
