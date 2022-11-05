package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.mapper.PostMapper;
import org.kevin.demo0212.model.Post;
import org.kevin.demo0212.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Kevin.Z
 * @version 2020-04-05
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;


    @Override
    public int insert(Post record) {
        return postMapper.insert(record);
    }

    @Override
    public Post getPostWithUser(String id) {
        return postMapper.getPostWithUser(id);
    }
}
