package com.hopu.mapper;

import com.hopu.entity.PackListC;

import java.util.List;

public interface PackListCMapper {

    public List<PackListC> selectPacklist();

    public int insertPack(PackListC entity);

    public PackListC selectPackByid(String packing_list_id);

    public int updatePack(PackListC entity);
}
