package com.xy.videosback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import lombok.Data;

import java.util.Date;

@Data
@TableName("search_history")
public class SearchHistory {
    @TableId(type = IdType.AUTO)
    private long id;

    @Column(name = "content", comment = "父类id")
    private String content;

    @Column(name = "createTime", comment = "父类id")
    private Date createTime;

    @Column(name = "num", comment = "父类id")
    private long num;


}
