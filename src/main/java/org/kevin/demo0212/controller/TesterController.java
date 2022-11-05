package org.kevin.demo0212.controller;

import org.kevin.demo0212.model.SecretMoment;
import org.kevin.demo0212.service.SecretMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-12
 */
@Controller
public class TesterController {

    @GetMapping("/getData")
    public String getData(){
        return "hello world~";
    }

    @GetMapping("/ioPage/{i}")
    public String ioPage(@PathVariable("i") int x) throws Exception {
        try{
            if(x < 10)
                throw new Exception();
        } catch (Exception e){
            if(x == 0)
                throw new IOException();
            else if(x == 1){
                throw new IndexOutOfBoundsException();
            } else {
                throw e;
            }
        }
        return "index";
    }

    @GetMapping("/tester/getUserBySecurity")
    @ResponseBody
    public String getUserBySecurity(){
        // 通过 SecurityContextHolder 获取的 principal 其实就是 Security 内置的 User 类
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return "1";
    }
}
