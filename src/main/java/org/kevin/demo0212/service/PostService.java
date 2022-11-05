package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Post;

/**
 * @author Kevin.Z
 * @version 2020-04-05
 */
public interface PostService {
    int insert(Post record);

    Post getPostWithUser(String id);
}
