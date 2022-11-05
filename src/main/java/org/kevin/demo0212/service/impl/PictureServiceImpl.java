package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.mapper.PictureMapper;
import org.kevin.demo0212.model.Picture;
import org.kevin.demo0212.service.BaseService;
import org.kevin.demo0212.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020/5/3
 */
@Service
public class PictureServiceImpl implements BaseService<Picture>, PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public int insert(Picture record) {
        return 0;
    }

    @Override
    public Picture getById(String id) {
        return null;
    }

    @Override
    public List<Picture> findList() {
        return null;
    }

    @Override
    public int insertBatch(List<Picture> pictures) {
        return pictureMapper.insertBatch(pictures);
    }
}
