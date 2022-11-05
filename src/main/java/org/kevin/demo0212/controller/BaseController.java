package org.kevin.demo0212.controller;

import org.kevin.demo0212.common.MyException;
import org.kevin.demo0212.model.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Kevin.Z
 * @version 2020-03-19
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    protected BlogUser getCurrentBlogUser() throws MyException {
        HttpSession session = request.getSession();
        BlogUser blogUser = (BlogUser)session.getAttribute("blogUser");
        if(blogUser == null){
            throw new MyException("there is not login user...");
        }

        return blogUser;
    }

}
