package com.xy.videosback.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VideoCoverUtil {
//    private static final Logger logger = LoggerFactory.getLogger(VideoCoverUtil.class);

    public static void main(String[] args) {
        Map<String, Object> vedioImg = getVedioImg("C:\\vue-web\\source", "vedio.mp4", 20);
        System.out.println(vedioImg);
    }

    /**
     * 获取视频图片
     *
     * @throws
     * @Title: gainVedioImg
     * @param: filePath  文件夹路径
     * @return: void
     */
    public static Map<String, Object> getVedioImg(String filePath, String fileName, int second) {
        return  getImage(filePath, fileName, second);
    }

    /**
     * 获取视频图片
     *
     * @throws
     * @Title: gainVedioImg
     * @param:
     * @return: void
     */
    public static Map<String, Object> getVedioImg(String filePath, String fileName) {
        return getImage(filePath, fileName, 1);
    }

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
            if (rotate != null) {
                //旋转图片
                bufferedImage = rotate(bufferedImage, Integer.parseInt(rotate));
            }
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
            System.out.println("截取视频截图结束：");
//            logger.debug("截取视频截图结束：" + System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println("获取视频图片失败：");
//            logger.error("获取视频图片失败！", e);
        }
        return result;
    }

    /**
     * 旋转 根据视频旋转度来调整图片
     * @param src
     * @param angel
     * @return
     */
    private static BufferedImage rotate(BufferedImage src, int angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        int type = src.getColorModel().getTransparency();
        Rectangle rect_des = calcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);
        BufferedImage bufferedImage = new BufferedImage(rect_des.width, rect_des.height, type);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
        graphics2D.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);
        graphics2D.drawImage(src, 0, 0, null);
        graphics2D.dispose();
        return bufferedImage;
    }

    /**
     * 计算图片旋转大小
     * @param src
     * @param angel
     * @return
     */
    private static Rectangle calcRotatedSize(Rectangle src, int angel) {
        if (angel >= 90) {
            if (angel / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }
        double totalSqrt = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double totalLen = 2 * Math.sin(Math.toRadians(angel) / 2) * totalSqrt;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);
        int len_width = (int) (totalLen * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
        int len_height = (int) (totalLen * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
        int des_width = src.width + len_width * 2;
        int des_height = src.height + len_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }

}
