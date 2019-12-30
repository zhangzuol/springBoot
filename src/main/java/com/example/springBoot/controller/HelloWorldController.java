/*******************************************************************
 * HelloWorldController.java   2017-9-7
 * Copyright 2015 by GNNT Company. All Rights Reserved.
 * Author:zhangzuoliang
 ******************************************************************/
package com.example.springBoot.controller;

import com.example.springBoot.domain.MyProperties;
import com.example.springBoot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>
 * <p><a href="HelloWorldController.java.html"><i>view source</i></a></p>
 * @version 0.1
 * @author <a href="mailto:zhangzuol@gnnt.com.cn">张祚良</a>
 * 
 */
@RestController
@RequestMapping("/actuator")
public class HelloWorldController {

	@RequestMapping("/hello")
    public String index() {
		//人生岂止于此，还有诗和远方
        return "Hello World !";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("张三");
        user.setPassword("123456");
        return user;
    }

    @RequestMapping("/getProperties")
    public String getProperties(){
        MyProperties pro = new MyProperties();
        return pro.getTitle()+"---"+pro.getDescription();
    }
}
