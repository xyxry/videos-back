package com.xy.videosback.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.xy.videosback.entity.SearchHistory;
import com.xy.videosback.service.FileService;
import com.xy.videosback.service.impl.FileServiceImpl;
import com.xy.videosback.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Size;
//import org.bytedeco.opencv.opencv_imgcodecs.Imgcodecs;
//import org.bytedeco.opencv.opencv_imgproc.Imgproc;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/file")
@Api(value = "文件接口", tags = {"文件接口"})
public class FileController {

    @Autowired
    FileService fileService ;

    @GetMapping("/queryLocalHostFile")
    @Operation(summary = "文件查询")
    public ResponseResult<JSONArray> index(@RequestParam(value = "path" ,required = false) String path){
        // 指定要扫描的文件夹路径
        String filePath = "C:/v" +
                "ue-web/source";
        if (StrUtil.isNotEmpty(path)){

            filePath = path;

            SearchHistory searchHistory = fileService.queryContent(path);
            if ( searchHistory != null){
                fileService.updateSearch(searchHistory);
            }else {
                fileService.saveSearch(path);
            }
        }
        // 创建顶层 JSON 对象
        JSONObject jsonResult = new JSONObject();
        // 调用扫描方法，传入文件夹路径和顶层 JSON 对象
        File file = new File(filePath);
        if (!file.exists()){
            return ResponseResult.success("路径不存在");
        }
        scanFolder(file, jsonResult ,"");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonResult);
        return ResponseResult.success(jsonArray);
    }
    @PostMapping("/saveFile")
    @Operation(summary = "保存")
    public ResponseResult<JSONObject> save(@RequestBody JSONObject param){

        return ResponseResult.success();
    }
//    public static void main(String[] args) {
//        String file = "C:/Users/hq/Desktop/解压这个文件夹到桌面打开";
//        // 指定要扫描的文件夹路径
//        String folderPath = "C:/path/to/folder";
//
//        // 创建顶层 JSON 对象
//        JSONObject jsonResult = new JSONObject();
//
//        // 调用扫描方法，传入文件夹路径和顶层 JSON 对象
//        scanFolder(new File(file), jsonResult);
//
//        // 打印最终生成的 JSON 结果
//        System.out.println(jsonResult.toString());
//    }

    public static void scanFolder(File folder, JSONObject parentJson , String path ) {
        // 判断是否为文件夹
        if (folder.isDirectory()) {
            // 创建一个 JSON 数组，用于存储当前文件夹的内容
            JSONArray jsonArray = new JSONArray();

            // 获取文件夹下的所有文件和子文件夹
            File[] files = folder.listFiles();

            if (files != null) {
                // 遍历每个文件和子文件夹
                for (File file : files) {
                    // 如果是文件夹，则创建一个新的 JSON 对象，并递归调用扫描方法
                    if (file.isDirectory()) {
                        JSONObject childJson = new JSONObject();
                        scanFolder(file, childJson , folder.getName());
//                        childJson.put(folder.getName(), childFiles);
                        jsonArray.put(childJson);
                    } else {
                        // 如果是文件，则将文件信息添加到 JSON 数组中
                        JSONObject fileJson = new JSONObject();
                        fileJson.put("size", file.length());
                        fileJson.put("path", path+"/"+file.getName());
                        fileJson.put("absolutPath", file.getAbsolutePath());
                        fileJson.put("fileName", file.getName());
                        fileJson.put("type", file.getParent());
                        jsonArray.put(fileJson);
                    }
                }
            }
            // 将 JSON 数组添加到父级 JSON 对象中
            parentJson.put("fileName", folder.getName());
            parentJson.put("path", folder.getPath());
            parentJson.put("type", "directory");
            parentJson.put("absolutPath", folder.getAbsolutePath());
            parentJson.put("children", jsonArray);
            parentJson.put("size", folder.length());
        }
    }
    @GetMapping("/searchHistory")
    @Operation(summary = "查询记录")
    public ResponseResult<List<SearchHistory>> searchHistory(){
        return ResponseResult.success(fileService.searchHistory());
    }
}
