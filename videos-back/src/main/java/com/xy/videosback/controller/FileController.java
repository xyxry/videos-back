package com.xy.videosback.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.xy.videosback.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
import java.util.Map;


@RestController
@RequestMapping("/file")
@Api(value = "文件接口", tags = {"文件接口"})
public class FileController {

    @GetMapping("/queryLocalHostFile")
    @Operation(summary = "测试")
    public ResponseResult<JSONObject> index(@RequestParam(value = "path" ,required = false) String path){
        // 指定要扫描的文件夹路径
        String file = "C:/Users/hq/Desktop/解压这个文件夹到桌面打开";
        if (StrUtil.isNotEmpty(path)){
            file = path;
        }
        // 创建顶层 JSON 对象
        JSONObject jsonResult = new JSONObject();
        // 调用扫描方法，传入文件夹路径和顶层 JSON 对象
        scanFolder(new File(file), jsonResult);
        return ResponseResult.success(jsonResult);
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

    public static void scanFolder(File folder, JSONObject parentJson) {
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
                        JSONArray childFiles = new JSONArray();
                        scanFolder(file, childJson);
//                        childJson.put(folder.getName(), childFiles);
                        jsonArray.put(childJson);
                    } else {
                        // 如果是文件，则将文件信息添加到 JSON 数组中
                        JSONObject fileJson = new JSONObject();
                        fileJson.put("size", file.length());
                        fileJson.put("path", file.getAbsolutePath());
                        fileJson.put("fileName", file.getName());

                        jsonArray.put(fileJson);
                    }
                }
            }

            // 将 JSON 数组添加到父级 JSON 对象中
//            parentJson.put("name", folder.getName());
//            parentJson.put("type", "folder");
            parentJson.put(folder.getName(), jsonArray);
        }
    }


}
