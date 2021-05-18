package com.dw.pjsipweb.controller;


import com.alibaba.fastjson.JSON;
import com.dw.pjsipweb.Util.UserStatus;
import com.dw.pjsipweb.entity.Role;
import com.dw.pjsipweb.entity.Room;
import com.dw.pjsipweb.service.IRoleService;
import com.dw.pjsipweb.service.IRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(description = "频道模块管理")
@RestController
@RequestMapping("/pjsipweb/room")
public class RoomController {
    @Autowired
    IRoleService roleService;

    @ApiOperation("查询domain聊天室中所有在线的人数")
    @GetMapping("domain")
    String findUserNumber(@PathVariable String domain){
        List<Role> line = (List<Role>) roleService.lambdaQuery().eq(Role::getDomain, domain).eq(Role::getState, UserStatus.OnLine);
        return JSON.toJSONString(line.size());
    }
}

