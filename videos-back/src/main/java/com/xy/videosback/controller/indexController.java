package com.xy.videosback.controller;

import com.xy.videosback.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping
@Api(value = "用户接口", tags = {"用户接口"})
public class indexController {

    @GetMapping("/index")
    @Operation(summary = "测试")
    public ResponseResult<Map> index(){
        Map map= new HashMap<>();
        for (int i =0;i<10;i++){
            map.put("name"+i,i);
        }
        return ResponseResult.success(map);
    }
}
