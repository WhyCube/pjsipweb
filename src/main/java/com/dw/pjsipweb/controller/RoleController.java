package com.dw.pjsipweb.controller;


import com.alibaba.fastjson.JSON;
import com.dw.pjsipweb.entity.Role;
import com.dw.pjsipweb.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author why
 * @since 2021-05-12
 */
@Api(description="角色模块管理")
@RestController
@RequestMapping("/pjsipweb/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @ApiOperation("使用ip登录domain聊天室")
    @PostMapping("domain/ip")
    String login(@PathVariable String domain, @PathVariable String ip){
        List<Role> line = (List<Role>) roleService.lambdaQuery().eq(Role::getDomain, domain).eq(Role::getIp, ip);
        if(line != null && line.size() == 1){
            return JSON.toJSONString("Success");
        }
        return JSON.toJSONString("Failure");
    }
}

