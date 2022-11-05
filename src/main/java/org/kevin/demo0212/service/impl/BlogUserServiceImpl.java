package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.mapper.BlogUserMapper;
import org.kevin.demo0212.model.BlogUser;
import org.kevin.demo0212.model.BlogUserExample;
import org.kevin.demo0212.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    private BlogUserMapper blogUserMapper;

    @Override
    public int insert(BlogUser record) {
        return blogUserMapper.insert(record);
    }

    @Override
    public List<BlogUser> findByUsername(String username) {
        BlogUserExample example = new BlogUserExample();
        example.createCriteria().andUsernameEqualTo(username);

        List<BlogUser> blogUsers = blogUserMapper.selectByExample(example);
        return blogUsers;
    }

    @Override
    public BlogUser findOneByUsername(String username) {
        List<BlogUser> blogUsers = this.findByUsername(username);
        if(blogUsers.size() != 1){
            return new BlogUser();
        }
        return blogUsers.get(0);
    }
}
