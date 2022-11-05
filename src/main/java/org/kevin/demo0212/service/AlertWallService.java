package org.kevin.demo0212.service;

import org.kevin.demo0212.model.AlertWall;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
public interface AlertWallService {
    AlertWall selectByType(int type);
}
