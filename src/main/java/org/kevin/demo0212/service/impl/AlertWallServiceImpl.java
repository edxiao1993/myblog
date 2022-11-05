package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.mapper.AlertWallMapper;
import org.kevin.demo0212.model.AlertWall;
import org.kevin.demo0212.model.AlertWallExample;
import org.kevin.demo0212.service.AlertWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Service
public class AlertWallServiceImpl implements AlertWallService {
    @Autowired
    private AlertWallMapper alertWallMapper;

    @Override
    public AlertWall selectByType(int type) {
        AlertWallExample example = new AlertWallExample();
        example.createCriteria().andTypeEqualTo(type);
        return alertWallMapper.selectByExample(example).get(0);
    }
}
