package com.java.spring_restful.controller;

import com.java.spring_restful.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Hello控制类")
public class HelloController {

    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    //只要我们的接口中，返回值中存在实体类，它就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //operation接口,不是放在类上的，是方法
    @ApiOperation("Post测试控制类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        int i = 5/0;
        return user;
    }

}
