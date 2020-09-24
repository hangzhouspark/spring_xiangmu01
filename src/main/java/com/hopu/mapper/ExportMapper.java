package com.hopu.mapper;

import com.hopu.entity.Export;

import java.util.List;

public interface ExportMapper {

    public List<Export> selectExp();

    public int insertExp(Export entity);

    public int delExp(String EXPORTPRODUCTID);

    public Export selectByidExp(String EXPORTPRODUCTID);

    public int updateExp(Export entity);
}
