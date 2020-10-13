package com.hopu.service.impl;

import com.hopu.entity.ExtCproductC;
import com.hopu.entity.ExtEproductC;
import com.hopu.mapper.ExtEproductCMapper;
import com.hopu.service.ExtEproductCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtEproductCServiceImpl implements ExtEproductCService {

    @Autowired
    private ExtEproductCMapper extEproductCMapper;

    @Override
    public int insertexe(ExtEproductC entity) {
        return extEproductCMapper.insertexe(entity);
    }
}
