package org.kevin.demo0212.service.impl;

import org.apache.ibatis.annotations.Param;
import org.kevin.demo0212.mapper.CuserMapper;
import org.kevin.demo0212.model.Cuser;
import org.kevin.demo0212.service.CuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 2020-04-05
 */
@Service
public class CuserServiceImpl implements CuserService {
    @Autowired
    private CuserMapper cuserMapper;

    @Override
    public Cuser getUserPost(String cuserId) {
        return cuserMapper.getUserPost(cuserId);
    }

    @Override
    public int insert(Cuser record) {
        return cuserMapper.insert(record);
    }
}
