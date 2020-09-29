package com.hopu.service.impl;

import com.hopu.entity.SysCodeB;
import com.hopu.mapper.SysCodeBMapper;
import com.hopu.service.SysCodeBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCodeBServiceImpl implements SysCodeBService {

    @Autowired
    private SysCodeBMapper sysCodeBMapper;

    @Override
    public List<SysCodeB> selectSys() {
        return sysCodeBMapper.selectSys();
    }
}
