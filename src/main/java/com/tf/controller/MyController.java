package com.tf.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;


/**
 * Created by t on 2016/10/31.
 */
@Controller
@RequestMapping( "/myTest" )
public class MyController {

    @ModelAttribute( "hello" )
    public String getModel() {
        System. out .println( "-------------Hello---------" );
        return "world" ;
    }

    @ModelAttribute ( "intValue" )
    public int getInteger() {
        System. out .println( "-------------intValue---------------" );
        return 10;
    }

    @RequestMapping ( "sayHello" )
    public void sayHello(@ModelAttribute ( "hello" ) String hello, @ModelAttribute ( "intValue" ) int num, @ModelAttribute ( "user2" ) SecurityProperties.User user, Writer writer, HttpSession session) throws IOException {
        writer.write( "Hello " + hello + " , Hello " + user.getName() + num);
        writer.write( "\r" );
        Enumeration enume = session.getAttributeNames();
        while (enume.hasMoreElements())
            writer.write(enume.nextElement() + "\r" );
    }

//    @ModelAttribute ( "user2" )
//    public SecurityProperties.User getUser() {
//        System. out .println( "---------getUser-------------" );
//        return new SecurityProperties.User(3, "user2" );
    }

