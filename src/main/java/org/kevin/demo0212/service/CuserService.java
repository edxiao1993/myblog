package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Cuser;

/**
 * @author Kevin.Z
 * @version 2020-04-05
 */
public interface CuserService {
    Cuser getUserPost(String cuserId);

    int insert(Cuser record);
}
