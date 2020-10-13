package com.hopu.service.impl;

import com.hopu.entity.ExportProC;
import com.hopu.mapper.ExportProCMapper;
import com.hopu.service.ExportProCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportProCServiceImpl implements ExportProCService {

    @Autowired
    private ExportProCMapper exportProCMapper;


    @Override
    public int insertexport(ExportProC entity) {
        return exportProCMapper.insertexport(entity);
    }
}
