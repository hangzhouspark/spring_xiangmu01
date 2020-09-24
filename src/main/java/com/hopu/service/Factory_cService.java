package com.hopu.service;

import com.hopu.entity.Factory_c;

import java.util.List;

public interface Factory_cService {

    /**
     * 查询所有
     */

    List<Factory_c> findfactoryAll();

    /**
     * 根据id查询
     */

    Factory_c findbyfactory_id(String factory_id);

    /**
     * 添加工厂
     */

    int addfactory_c(Factory_c entity);

    /**
     * 修改工厂
     */

    int updatefactory_c(Factory_c entity);

    int updateastate(Factory_c entity);

    int deleteFactoryC(String factory_id);
}
