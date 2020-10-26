package com.java.spring_restful.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Api(注释)
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
