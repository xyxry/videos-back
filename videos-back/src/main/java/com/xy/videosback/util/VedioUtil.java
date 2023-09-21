package com.xy.videosback.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VedioUtil {
    private static Map<String, Object> getImage(String filePath, String fileName, int second) {
        Map<String, Object> result = new HashMap<String, Object>();
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdirs();//如果文件夹不存在则创建
        }
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath + File.separator + fileName);
            grabber.start();
            int ftp = grabber.getLengthInFrames();
            int flag = 0;
            Frame frame = null;
            while (flag <= ftp) {
                //获取帧
                frame = grabber.grabImage();
                //过滤前 second 帧，避免出现全黑图片
                if ((flag > second) && (frame != null)) {
                    break;
                }
                flag++;
            }
            String rotate = grabber.getVideoMetadata("rotate");
            //创建BufferedImage对象
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage bufferedImage = converter.getBufferedImage(frame);
//            if (rotate != null) {
//                //旋转图片
//                bufferedImage = rotate(bufferedImage, Integer.parseInt(rotate));
//            }
            String newFileName = filePath + File.separator + fileName.substring(0, fileName.lastIndexOf(".")) + ".jpeg";
            File file = new File(newFileName);
            ImageIO.write(bufferedImage, "jpeg", file);
            //拼接Map信息
            result.put("videoWide", bufferedImage.getWidth());
            result.put("videoHigh", bufferedImage.getHeight());
            long duration = grabber.getLengthInTime() / (1000 * 1000);
            result.put("rotate", StringUtils.isEmpty(rotate) ? "0" : rotate);
            result.put("format", grabber.getFormat());
            result.put("imgPath", file.getPath());
            result.put("time（s/秒）", duration);
            grabber.close();
            grabber.stop();
//            logger.debug("截取视频截图结束：" + System.currentTimeMillis());
        } catch (Exception e) {
//            logger.error("获取视频图片失败！", e);
        }
        return result;
    }

}
