package com.hopu.service.impl;

import com.hopu.entity.PackListC;
import com.hopu.mapper.PackListCMapper;
import com.hopu.service.PackListCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackListCServiceImpl implements PackListCService {

    @Autowired
    private PackListCMapper packListCMapper;

    @Override
    public List<PackListC> selectPacklist() {
        return packListCMapper.selectPacklist();
    }

    @Override
    public int insertPack(PackListC entity) {
        return packListCMapper.insertPack(entity);
    }

    @Override
    public PackListC selectPackByid(String packing_list_id) {
        return packListCMapper.selectPackByid(packing_list_id);
    }

    @Override
    public int updatePack(PackListC entity) {
        return packListCMapper.updatePack(entity);
    }
}
