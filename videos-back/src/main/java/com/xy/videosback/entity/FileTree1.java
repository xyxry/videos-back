package com.xy.videosback.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import lombok.Data;

@TableName("file_entity")
@Data
public class FileTree1 {
    @TableId(type = IdType.AUTO)
    private String id;

    @Column(name = "parentId" , comment = "父类id")
    private String parentId;

    @Column(name = "fileName" , comment = "文件名")
    private String fileName;

    @Column(name = "path" , comment = "相对路径")
    private String path;

    @Column(name = "absolutPath" , comment = "绝对路径")
    private String absolutPath;

    @Column(name = "size" , comment = "文件大小")
    private String size;

    @Column(name = "classification" , comment = "分类")
    private String classification;

    @Column(name = "type" , comment = "类型1 文件夹 2 文件")
    private String type;

    @Column(name = "lable" , comment = "标签")
    private String lable;
}




