package com.hopu.service.impl;

import com.hopu.entity.Export;
import com.hopu.mapper.ExportMapper;
import com.hopu.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportMapper exportMapper;

    @Override
    public List<Export> selectExp() {
        return exportMapper.selectExp();
    }

    @Override
    public int insertExp(Export entity) {
        return exportMapper.insertExp(entity);
    }

    @Override
    public int delExp(String EXPORTPRODUCTID) {
        return exportMapper.delExp(EXPORTPRODUCTID);
    }

    @Override
    public Export selectByidExp(String EXPORTPRODUCTID) {
        return exportMapper.selectByidExp(EXPORTPRODUCTID);
    }

    @Override
    public int updateExp(Export entity) {
        return exportMapper.updateExp(entity);
    }
}
