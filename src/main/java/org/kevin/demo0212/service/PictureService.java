package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Picture;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020/5/3
 */
public interface PictureService {
    int insertBatch(List<Picture> pictures);
}
