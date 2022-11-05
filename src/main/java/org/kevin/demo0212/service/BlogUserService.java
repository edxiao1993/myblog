package org.kevin.demo0212.service;

import org.kevin.demo0212.model.BlogUser;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
public interface BlogUserService {
    int insert(BlogUser record);

    List<BlogUser> findByUsername(String username);

    BlogUser findOneByUsername(String username);
}
