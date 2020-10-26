package com.java.spring_restful.controller;

import com.java.spring_restful.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Hello控制类")
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    //只要我们的接口中，返回值中存在实体类，它就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(@RequestBody User user){
        return user;
    }

    @PostMapping(value = "/user2/{username}/{password}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",defaultValue = "username",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "password",dataType = "String",required = true)
    })
    public User user(@ApiParam("用户名") @PathVariable("username") String name,
                     @ApiParam("密码") @PathVariable("password") String password){
        return new User(name,password);
    }


    //operation接口,不是放在类上的，是方法
    @ApiOperation("Post测试控制类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        int i = 5/0;
        return user;
    }
}