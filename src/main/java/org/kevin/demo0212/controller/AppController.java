package org.kevin.demo0212.controller;

import org.kevin.demo0212.model.BlogUser;
import org.kevin.demo0212.model.dto.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Kevin.Z
 * @version 2020-03-31
 */
@RestController
@RequestMapping("/app")
public class AppController {

//    @RequestMapping(method = RequestMethod.POST, value = "/first")
    @PostMapping("/first")
    public ResultData i1(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        BlogUser user = new BlogUser();
        user.setUsername(name);
        user.setStatus(true);

        ResultData<BlogUser> me = new ResultData<>();
        me.setCode(200);
        me.setMsg("done");
        me.setData(user);
        response.setHeader("token3", new Date().toString());

        return me;
    }
}
