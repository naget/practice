package com.tf.controller;

import com.tf.server.ServerImp.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by t on 2016/10/22.
 */
@Controller
public class TianController {
    @Autowired
    private UserServer userServer;

//    @Autowired
//    private User user;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login()
    {

        return "login";
    }
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }



}
