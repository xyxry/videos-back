package com.xy.videosback.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.exception.word.WordExportException;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy.videosback.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
@Api(value = "用户接口", tags = {"用户接口"})
public class indexController {

    @GetMapping("/index")
    @Operation(summary = "测试")
    public ResponseResult<Map> index() {
        String url = "E:/新建文件夹/姓名 - 副本 (2).docx";
        String url2 = "E:/新建文件夹/image/aa.docx";
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("birth", "2014-12-25");
//        map.put("photo", "E:/新建文件夹/712C544E7461E281855381D97B045875.jpg");
//        map.put("birPlace", "贰佰万");
//        map.put("place", "技有限公司");
//        map.put("email", "aas@qq.com");
//        map.put("name", "JueYue");
//        map.put("phone", "1879740****");
//        map.put("sex", "男");
//        map.put("nation", "汉");

//        ImageEntity imageEntity = new ImageEntity();
//        imageEntity.setHeight(185);
//        imageEntity.setWidth(135);
//        imageEntity.setUrl("E:/新建文件夹/712C544E7461E281855381D97B045875.jpg");
//        imageEntity.setType(ImageEntity.URL);

        List list = new ArrayList();

        for (int i = 0; i < 5; i++) {
            Map haMap = new HashMap();
//            haMap.put("ph2", imageEntity);
            haMap.put("ph1", "测试"+i);
            haMap.put("ph2", "wc"+i);
            list.add(haMap);
        }
//        map.put("photo", imageEntity);
        map.put("list", list);
        try {
            XWPFDocument xwpfDocument = WordExportUtil.exportWord07(url, map);
            FileOutputStream fileOutputStream = new FileOutputStream(url2);
            xwpfDocument.write(fileOutputStream);
            xwpfDocument.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.success(map);
    }

//    @GetMapping("/index2")
//    @Operation(summary = "测试2")
//    public ResponseResult<Map> index2(){
//        String url = "E:/新建文件夹/姓名 - 副本.docx";
//        String url2 = "E:/新建文件夹/image/aa.docx";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("birth", "2014-12-25");
//        map.put("photo", "E:/新建文件夹/712C544E7461E281855381D97B045875.jpg");
//        map.put("birPlace", "贰佰万");
//        map.put("place", "技有限公司");
//        map.put("email", "aas@qq.com");
//        map.put("name", "JueYue");
//        map.put("phone", "1879740****");
//        map.put("sex", "男");
//        map.put("nation", "汉");
//
//        ImageEntity imageEntity = new ImageEntity();
//        imageEntity.setHeight(185);
//        imageEntity.setWidth(135);
//        imageEntity.setUrl("E:/新建文件夹/712C544E7461E281855381D97B045875.jpg");
//        imageEntity.setType(ImageEntity.URL);
//        Map haMap =new HashMap();
//        haMap.put("ph2",imageEntity);
//        haMap.put("ph1","测试1");
//        List list = new ArrayList();
//        list.add(haMap);
//        haMap.put("ph1","测试2");
//        list.add(haMap);
//        map.put("photo",imageEntity);
//        map.put("list",list);
//        try {
//            XWPFDocument xwpfDocument = WordExportUtil.exportWord07(url, map);
//            FileOutputStream fileOutputStream = new FileOutputStream(url2);
//            xwpfDocument.write(fileOutputStream);
//            xwpfDocument.close();
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseResult.success(map);
//    }



}
