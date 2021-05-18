package com.dw.pjsipweb.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dw.pjsipweb.Util.UserStatus;
import com.dw.pjsipweb.entity.Role;
import com.dw.pjsipweb.service.IRoleService;
import com.dw.pjsipweb.service.impl.RoleServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleStatus;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author why
 * @since 2021-05-12
 */
@Api(description="录音模块管理")
@RestController
@RequestMapping("/pjsipweb/record")
public class RecordController {

    @Autowired
    IRoleService roleService;

    @GetMapping(value = "/users")
    String getuserList(String room){
        List<Role> res=roleService.lambdaQuery().eq(Role::getDomain,room).eq(Role::getState, UserStatus.OnLine.getCode()).list();

        List<String> ip_list=res.stream().map(Role::getIp).collect(Collectors.toList());

        return JSON.toJSONString(ip_list);
    }

    @PostMapping(value = "/status/{username}/{status}")
    String SetStatus(@PathVariable("username")String username,@PathVariable("status")String status){

        int code=0;
        switch (status){
            case "OnLine":code=UserStatus.OnLine.getCode();break;
            case "OffLine":code=UserStatus.OFFLine.getCode();break;
            case "Busy":code=UserStatus.Busy.getCode();break;
            default:return JSON.toJSONString("无此状态!");
        }
        boolean res =roleService.lambdaUpdate().eq(Role::getName,username).set(Role::getState,code).update();
        if(res)return JSON.toJSONString("Success");
        return JSON.toJSONString("Failed");
    }


    @GetMapping(value="/status/{username}")
    String getStatus(@PathVariable("username")String username){
        int code=roleService.lambdaQuery().eq(Role::getName,username).one().getState();
        String res="";
        switch (UserStatus.GetStatus(code)){
            case Busy:res="Busy";break;
            case OnLine:res="OnLine";break;
            case OFFLine:res="OFFLine";break;
        }
        return JSON.toJSONString(res);
    }



}

