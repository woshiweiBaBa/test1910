package com.bjpowernode.springboot.controller;/**
 * className:UserController
 * package:com.bjpowernode.springboot.controller
 * Description:
 *
 * @date:2019/10/9 22:13
 * @author:LiuJingWei
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:刘经纬
 * 2019/10/9
 */

@RestController
public class UserController {

    @Reference   //用于注入远程Dubbo暴露出来的服务
    private UserService userService;

    @RequestMapping(value = "/add")
    public Object add(User user){
        userService.addUser(user);
        return "添加成功:"+user;
    }

    @RequestMapping(value = "/get")
    public Object get(){
        User user = userService.getUser();
        return "查询成功:"+user;
    }
}
